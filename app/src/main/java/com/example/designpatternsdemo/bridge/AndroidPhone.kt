package com.example.designpatternsdemo.bridge

import android.content.Context
import com.example.designpatternsdemo.showMessage

class AndroidPhone(val context: Context): Smartphone {
    override fun mute() {
        context.showMessage("Opens Settings, opens voice settings, tap on mute")
    }

    override fun openSmartAssistant() {
        context.showMessage("Hey Google")
    }
}