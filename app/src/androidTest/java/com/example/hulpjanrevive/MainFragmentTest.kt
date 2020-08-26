package com.example.hulpjanrevive


import android.app.DatePickerDialog
import android.view.Gravity
import android.widget.DatePicker
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.GeneralLocation
import androidx.test.espresso.action.GeneralSwipeAction
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Swipe
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.contrib.DrawerMatchers.isOpen
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Character.getName


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainFragmentTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.hulpjanrevive", appContext.packageName)
    }

    @Test
    fun mainFragmentLaunch() {
        onView(withId(R.id.layout_main_fragment)).check(matches(isDisplayed()))
    }

    @Test
    fun checkFabButton() {
        onView(withId(R.id.add_new)).check(matches(isDisplayed()))
        onView(withId(R.id.add_new)).perform(click())
        onView(withClassName(Matchers.equalTo(DatePicker::class.java.name))).check(matches(
            isDisplayed()))
    }

}