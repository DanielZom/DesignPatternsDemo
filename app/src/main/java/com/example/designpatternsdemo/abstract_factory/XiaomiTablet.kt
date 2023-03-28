package com.example.designpatternsdemo.abstract_factory

import android.content.Context
import com.example.designpatternsdemo.showMessage

class XiaomiTablet(private val context: Context): TabletDevice {

    override fun openMediaAppOnBigScreen() {
        context.showMessage("Watching Youtube on Xiaomi, comfortably")
    }
}