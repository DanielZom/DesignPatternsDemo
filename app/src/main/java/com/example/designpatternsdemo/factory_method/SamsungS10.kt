package com.example.designpatternsdemo.factory_method

import android.content.Context
import com.example.designpatternsdemo.showMessage

class SamsungS10(private val context: Context): SamsungMobile {
    override fun call(phoneNumber: String) {
        context.showMessage("SamsungS10 is calling $phoneNumber...")
    }

    override fun takePhoto(): ByteArray {
        context.showMessage("SamsungS10 has saved the photo")
        return byteArrayOf(0x00, 0xff.toByte(), 0xf4.toByte())
    }

    override fun openApp(appName: String) {
        context.showMessage("SamsungS10 is opening $appName")
    }
}