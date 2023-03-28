package com.example.designpatternsdemo.bridge

import android.content.Context
import com.example.designpatternsdemo.showMessage

class Iphone(val context: Context): Smartphone {

    override fun mute() {
        context.showMessage("Slides the physical button to mute state")
    }

    override fun openSmartAssistant() {
        context.showMessage("Hey Siri")
    }
}