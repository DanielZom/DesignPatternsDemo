package com.example.designpatternsdemo.builder

class PhoneDirector private constructor() {

    var batteryMha: Int? = null
    var cameraMegapixel: Int? = null
    var screenType: ScreenType? = null
    var ramMb: Int? = null

    class PhoneBuilder {
        private var batteryMha: Int? = null
        private var cameraMegapixel: Int? = null
        private var screenType: ScreenType? = null
        private var ramMb: Int? = null

        fun addBattery(mha: Int): PhoneBuilder {
            batteryMha = mha
            return this
        }

        fun addCamera(megapixel: Int): PhoneBuilder {
            cameraMegapixel = megapixel
            return this
        }

        fun addScreen(type: ScreenType): PhoneBuilder {
            screenType = type
            return this
        }

        fun addRam(mb: Int): PhoneBuilder {
            ramMb = mb
            return this
        }

        fun create(): PhoneDirector {
            return PhoneDirector().apply {
                this.batteryMha = this@PhoneBuilder.batteryMha
                this.ramMb = this@PhoneBuilder.ramMb
                this.cameraMegapixel = this@PhoneBuilder.cameraMegapixel
                this.screenType = this@PhoneBuilder.screenType
            }
        }
    }
}

enum class ScreenType {
    AMOLED, IPS
}