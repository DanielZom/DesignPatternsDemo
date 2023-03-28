package com.example.designpatternsdemo.prototype

class HuaweiMate20: PhonePrototype {

    var cpuMhz: Int? = null
    var batteryCapacity: Int? = null
    var cameraMegapixel: Int? = null

    override fun clone(): HuaweiMate20 {
        return HuaweiMate20().apply {
            cpuMhz = this@HuaweiMate20.cpuMhz
            batteryCapacity = this@HuaweiMate20.batteryCapacity
            cameraMegapixel = this@HuaweiMate20.cameraMegapixel
        }
    }
}