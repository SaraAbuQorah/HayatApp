package com.example.hayatapp.location

import android.app.Notification
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.hayatapp.R
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import okhttp3.internal.notify


class LocationService: Service(){
    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private lateinit var locationClient: LocationClient

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        locationClient=DefaultLocationClient(
            applicationContext,
            LocationServices.getFusedLocationProviderClient(applicationContext)
        )
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action){
            Action_Start -> start()
            Action_Stop -> stop()
        }
        return super.onStartCommand(intent, flags, startId)
    }
    private fun start(){
        val notification =NotificationCompat.Builder(this,"location")
            .setContentTitle("Your Location ...")
            .setContentText("Location: null")
            .setSmallIcon(R.drawable.notification)
            .setOngoing(true)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        locationClient
            .getLocationUpdates(10000L)
            .catch { e -> e.printStackTrace() }
            .onEach { location ->
                val lat = location.latitude.toString()
                val long = location.longitude.toString()
                val updatedNotification = notification.setContentText(
                    "Location: ($lat , $long)"
                )
                notificationManager.notify(1,updatedNotification.build())
            }
            .launchIn(serviceScope)

        startForeground(1,notification.build())
    }
    private fun stop(){
        stopForeground(true)
        stopSelf()
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }
    companion object{
        const val Action_Start = "Action_Start"
        const val Action_Stop = "Action_Stop"

    }
}