package com.example.hayatapp.ui.requestOrder

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class RequestViewModel(): ViewModel() {
    val isNewiSelected = ObservableBoolean(true)
    val isProcessingSelected = ObservableBoolean(false)

    fun onNewiClicked() {
        isNewiSelected.set(true)
        isProcessingSelected.set(false)
    }

    fun onProcessingClicked() {
        isNewiSelected.set(false)
        isProcessingSelected.set(true)
    }
}