package com.example.designpatternsdemo.abstract_factory

import android.content.Context
import com.example.designpatternsdemo.showMessage

class XiaomiMobile(private val context: Context): MobileDevice {
    override fun call(phoneNumber: String) {
        context.showMessage("Xiaomi is calling $phoneNumber...")
    }
}