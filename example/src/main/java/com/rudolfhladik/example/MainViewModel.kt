package com.rudolfhladik.example

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rudolfhladik.debouncable.Debouncable

class MainViewModel : ViewModel() , Debouncable {
    val btnOneClickAction = MutableLiveData<String>()
    val btnTwoClickAction = MutableLiveData<String>()
    fun onBtnOne() = debounceAction {
        btnOneClickAction.value = "click 1"
    }

    fun onBtnTwo() = debounceAction{
        btnTwoClickAction.value = "click 2"
    }
}
