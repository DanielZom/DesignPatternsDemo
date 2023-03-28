package com.example.designpatternsdemo.singleton

import com.example.designpatternsdemo.factory_method.SamsungMobile

//Kotlin has an "object" type of class, which is already a Singleton, but I'd like to make a real example
class SamsungMobileTester private constructor() {

    var isTestingStarted = false
        private set
    val name = "Zombori Dániel"
    var phonesGotForTesting = arrayListOf<SamsungMobile>()
    set(value) {
        isTestingStarted = value.isNotEmpty()
        field = value
    }

    companion object {
        private var instance: SamsungMobileTester? = null

        fun getInstance(): SamsungMobileTester {
            if (instance == null) instance = SamsungMobileTester()
            return instance!!
        }
    }
}