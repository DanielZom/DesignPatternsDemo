package com.example.designpatternsdemo.abstract_factory

import android.content.Context
import com.example.designpatternsdemo.showMessage

class SamsungTablet(private val context: Context): TabletDevice {
    override fun openMediaAppOnBigScreen() {
        context.showMessage("Watching Netflix on Samsung, comfortably")
    }
}