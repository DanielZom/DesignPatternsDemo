package com.example.designpatternsdemo.factory_method

import android.content.Context

abstract class SamsungGalaxyFactory {
    abstract fun create(context: Context): SamsungMobile
}

class SamsungS22Factory: SamsungGalaxyFactory() {
    override fun create(context: Context): SamsungMobile {
        return SamsungS22(context)
    }
}

class SamsungS10Factory: SamsungGalaxyFactory() {
    override fun create(context: Context): SamsungMobile {
        return SamsungS10(context)
    }

}