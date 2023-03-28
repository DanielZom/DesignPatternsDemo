package com.example.designpatternsdemo.abstract_factory

import android.content.Context

interface AndroidFactory {
    fun createMobile(): MobileDevice
    fun createTablet(): TabletDevice
}

class SamsungDeviceFactory(private val context: Context): AndroidFactory {
    override fun createMobile(): MobileDevice {
        return SamsungMobile(context)
    }

    override fun createTablet(): TabletDevice {
        return SamsungTablet(context)
    }
}

class XiaomiDeviceFactory(private val context: Context): AndroidFactory {
    override fun createMobile(): MobileDevice {
        return XiaomiMobile(context)
    }

    override fun createTablet(): TabletDevice {
        return XiaomiTablet(context)
    }
}