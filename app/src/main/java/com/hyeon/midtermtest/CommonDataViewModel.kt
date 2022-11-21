package com.hyeon.midtermtest

import androidx.lifecycle.ViewModel

class CommonDataViewModel : ViewModel() {
    var inputString = ""

    fun saveString(str:String){
        inputString = str
    }
}