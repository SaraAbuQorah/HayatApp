package com.example.hayatapp.ui.home

import android.Manifest
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.location.Location
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.navigation.fragment.findNavController
import com.example.hayatapp.App
import com.example.hayatapp.R
import com.example.hayatapp.databinding.FragmentHomeMApBinding
import com.example.hayatapp.location.LocationService
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class HomeMApFragment : Fragment() , OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMarkerClickListener{
    private lateinit var binding: FragmentHomeMApBinding
    private var mGoogleMap: GoogleMap? = null
    private lateinit var lastLocation: Location
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var isClick:Boolean=false
    companion object {
        private const val LOCATION_REQUEST_CODE = 1
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeMApBinding.inflate(inflater, container, false)
        binding.goToProfileIcon.setOnClickListener {
            findNavController().navigate(HomeMApFragmentDirections.actionHomeMApFragmentToProfileFragment())
        }
        binding.request.setOnClickListener {
            findNavController().navigate(HomeMApFragmentDirections.actionHomeMApFragmentToRequestOrderListFragment())
        }

        val mapFragment = childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        return binding.root
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap

        mGoogleMap?.uiSettings?.isZoomControlsEnabled = true
        mGoogleMap?.setOnMarkerClickListener(this)
        setUpMap()
    }

    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.ACCESS_FINE_LOCATION) !=
            android.content.pm.PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_REQUEST_CODE
            )
            return
        }


        mGoogleMap?.isMyLocationEnabled = true

        fusedLocationClient.lastLocation.addOnSuccessListener(requireActivity()) { location ->
            if (location != null) {
                lastLocation = location
                val currentLatLong = LatLng(location.latitude, location.longitude)
                placeMarkerOnMap(currentLatLong)
                mGoogleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLong, 12f))
                binding.onOffLine.setOnClickListener {
                    if(isClick){
                        Intent(requireContext(), LocationService::class.java).apply {
                            action= LocationService.Action_Start
                            requireContext().startService(this)

                        }
                        binding.onOffLine.setImageResource(R.drawable.group553)
                        isClick=false
                    }else{
                        Intent(requireContext(), LocationService::class.java).apply {
                            action= LocationService.Action_Stop
                            requireContext().startService(this)
                        }
                        binding.onOffLine.setImageResource(R.drawable.group552)
                        isClick=true
                    }

                }
            }else {
                Log.e("MapDebug", "GoogleMap is null")
            }
        }
    }

    private fun placeMarkerOnMap(currentLatLong: LatLng) {
        val markerOptions = MarkerOptions().position(currentLatLong)
        markerOptions.title("${currentLatLong}")
        Log.e("MapDebug1", "GoogleMap is ${currentLatLong}")
        val markerBitmap = BitmapFactory.decodeResource(resources, R.drawable.car)
        val resizedMarkerBitmap = Bitmap.createScaledBitmap(markerBitmap, 64, 64, false)
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(resizedMarkerBitmap))
        mGoogleMap?.addMarker(markerOptions)
    }

    override fun onMarkerClick(p0: Marker)=false
    override fun onMapClick(p0: LatLng) {
    }


}