package com.example.moniepoint

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

private const val TIME_OUT = 5_000L
@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 18)
class AutomationTest {

    private lateinit var device: UiDevice

    @Before
    fun startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        // Use shell command to launch the app:
        // https://falsinsoft.blogspot.com/2015/05/launch-app-from-android-shell-terminal.html#:~:text=If%20you%20want%20to%20launch,interface%20to%20the%20system%20ActivityManager
        device.executeShellCommand("am start -n com.example.moniepoint/com.example.moniepoint.MainActivity")
    }

    @Test
    fun testThatTheAppHasAllExpectedFeatures() {
        // The app has been launched but we need to wait a bit for the app's UI composables to be displayed.
        // This is because some android devices are slow and when they launch an app (especially for the first time),
        // they will show a default splash screen (or a blank white screen) briefly before showing the UI of the app.

        // This splash/blank screen will cause problems for your UI tests because UIAutomator begins testing
        // immediately the first UI of the app appears. Now, since it is the splash/blank screen that appears first,
        // UIAutomator will run all your tests on that splash/blank screen.

        // This will cause all your tests to run and fail before the actual expected UI composables
        // have a chance to be drawn on the screen.

        // So, the first thing to do is wait until we are sure that the composable we want to test for is visible:
        device.wait(Until.hasObject(By.res("Home" )), TIME_OUT)

        // Now, check that the Home feature exist:
        val homeMenu = device.findObject(By.res("Home"))
        homeMenu.click()

        // check that the Calculate feature exist:
        device.wait(Until.hasObject(By.res("Calculate" )), TIME_OUT)
        val calculateMenu = device.findObject(By.res("Calculate"))
        calculateMenu.click()

        // check that the Shipment feature exist:
        device.pressBack()
        device.wait(Until.hasObject(By.res("Shipment" )), TIME_OUT)

        val shipmentMenu = device.findObject(By.res("Shipment"))
        shipmentMenu.click()
    }
}