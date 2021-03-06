package com.androiddasar.anjar

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
//
//    lateinit var mainActivityScenario: ActivityScenario<MainActivity>
//
//    @Before
//    fun setUp() {
//        mainActivityScenario = ActivityScenario.launch(MainActivity::class.java)
//    }
//
//
//    @After
//    fun tearDown() {
//        mainActivityScenario.close()
//    }

    @get:Rule
    var mainActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testSayHello() {
        onView(withId(R.id.nameEditText))
            .perform(typeText("Anjar"))

        onView(withId(R.id.sayHelloButton))
      .perform(click())

        onView(withId(R.id.sayHelloTextView))
            .check(matches(withText("Halo Anjar")))

        Thread.sleep(2000)
    }


}