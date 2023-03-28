package com.example.designpatternsdemo.factory_method

interface SamsungMobile {
    fun call(phoneNumber: String)
    fun takePhoto(): ByteArray
    fun openApp(appName: String)
}