package com.example.designpatternsdemo.bridge

class SmartphoneUser(private val smartphone: Smartphone) {

    fun mutePhone() {
        smartphone.mute()
    }

    fun openAssistantByVoice() {
        smartphone.openSmartAssistant()
    }
}