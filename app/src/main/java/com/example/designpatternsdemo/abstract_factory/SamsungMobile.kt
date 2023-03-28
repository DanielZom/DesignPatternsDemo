package com.example.designpatternsdemo.abstract_factory

import android.content.Context
import com.example.designpatternsdemo.showMessage

class SamsungMobile(private val context: Context): MobileDevice {
    override fun call(phoneNumber: String) {
        context.showMessage("Samsung is calling $phoneNumber...")
    }
}