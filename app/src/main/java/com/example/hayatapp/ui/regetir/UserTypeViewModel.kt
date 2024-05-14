package com.example.hayatapp.ui.regetir

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hayatapp.R
import com.example.hayatapp.data.UserTypeData


class UserTypeViewModel : ViewModel() {
    private val _userTypeList = MutableLiveData<List<UserTypeData>>()
    val userTypeList: LiveData<List<UserTypeData>> get() = _userTypeList

    init {
        _userTypeList.value = listOf(
            UserTypeData(R.drawable.group845, R.drawable.ellipse37, "A Delivery Driver"),
            UserTypeData(R.drawable.group844, R.drawable.ellipse37, "Looking for a Driver")
        )
    }
}

