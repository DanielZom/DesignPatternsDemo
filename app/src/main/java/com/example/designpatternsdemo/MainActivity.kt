package com.example.designpatternsdemo

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.designpatternsdemo.abstract_factory.SamsungDeviceFactory
import com.example.designpatternsdemo.abstract_factory.XiaomiDeviceFactory
import com.example.designpatternsdemo.adapter.AuthDataAdapter
import com.example.designpatternsdemo.adapter.AuthDataValidator
import com.example.designpatternsdemo.bridge.Iphone
import com.example.designpatternsdemo.bridge.SmartphoneUser
import com.example.designpatternsdemo.builder.PhoneDirector
import com.example.designpatternsdemo.builder.ScreenType
import com.example.designpatternsdemo.factory_method.SamsungS10Factory
import com.example.designpatternsdemo.factory_method.SamsungS22Factory
import com.example.designpatternsdemo.prototype.HuaweiMate20
import com.example.designpatternsdemo.singleton.SamsungMobileTester

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Factory method - create a specific product, exactly what I need
        //Example: Creates a specific class, what I need, and every time when I need it (for example a Fragment)
        val samsung22Mobile = SamsungS22Factory().create(this)
        val samsung10Mobile = SamsungS10Factory().create(this)
        //Singleton There is only on of this class in the app's lifecycle,
        // but it will be initialized the first time when it's being used
        //Example: Room instance
        SamsungMobileTester.getInstance().phonesGotForTesting = arrayListOf(samsung22Mobile, samsung10Mobile)

        if (SamsungMobileTester.getInstance().isTestingStarted) {
            showMessage("${SamsungMobileTester.getInstance().name} has started testing the mobiles")

            samsung22Mobile.call("+36201234567")
            samsung10Mobile.openApp("Instagram")
        }

        //Abstract factory - create a product, but doesn't matter what type is it, but it has to be in the same category
        //Example: I ask for a json mapper class, but it doesn't matter which one (for example Gson, JacksonParser...)
        val samsungDeviceFactory = SamsungDeviceFactory(this)
        val xiaomiDeviceFactory = XiaomiDeviceFactory(this)

        val samsungMobile = samsungDeviceFactory.createMobile()
        val xiaomiTablet = xiaomiDeviceFactory.createTablet()

        samsungMobile.call("06201234567")
        xiaomiTablet.openMediaAppOnBigScreen()

        //Adapter - convert data for a different format, or to a legacy service what needs it in an other way
        // with this we don't need to destroy the existing logic to adapt the new technology
        //Example: The most obvious example is the RecyclerView's adapter class, we convert the data to a whole UI list item
        val adapter = AuthDataAdapter()
        val authDataValidator = AuthDataValidator(adapter)
        val isDataValid = authDataValidator.validateAuthData("abc")

        if (isDataValid) {
            showMessage("Auth data is valid! Successful login!")
        }

        //Builder - rather than create specific phones (e.g. Samsung S22, Iphone 13), it can build any phone from scratch
        // by splitting up it's creation phase (e.g. a SamsungS22 differs from an Iphone by it's screen type, but there
        // are a few components which are not the same, like the metal case)
        //Example: Gson, PicassoHelper, OKHTTP
        val phoneDirector = PhoneDirector.PhoneBuilder()
            .addRam(4096)
            .addCamera(100)
            .addBattery(5000)
            .addScreen(ScreenType.AMOLED)
            .create()
        PhoneDirector.PhoneBuilder()
        showMessage("Phone created: RAM: ${phoneDirector.ramMb}," +
                " camera: ${phoneDirector.cameraMegapixel}mpx," +
                " screen type: ${phoneDirector.screenType?.name}, battery: ${phoneDirector.batteryMha}MhA")

        //Prototype - creating a shallow copy of an object to be abel to use on other places
        //Example: There are a two java solution for this, SerializationUtils and Cloneable which are creates deep copies of objects
        // shallow copies can be created by hand with this design pattern
        val huawei = HuaweiMate20().apply {
            cpuMhz = 2350
            batteryCapacity = 4500
            cameraMegapixel = 80
        }
        showMessage("Huawei is created ${huawei.hashCode()}")
        showMessage("A copy of the original Huawei is created ${huawei.clone().hashCode()}")

        //Bridge - Transforms actions/data to several implementations (similar to Adapter, but this can be implemented,
        // before the source/implementation has been done)
        //Example: A multiplatform app's popup manager class. It should be showing the platform default popup, either on iOS
        // or Android
        val smartphoneUser = SmartphoneUser(Iphone(this))
        smartphoneUser.openAssistantByVoice()
        smartphoneUser.mutePhone()
    }
}

fun Context.showMessage(message: String) {
//    Log.e("TEST LOG", message)
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}