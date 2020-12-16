package com.example.mytictaktoe

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import kotlinx.android.synthetic.main.activity_main.*

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{
    @Rule
    @JvmField
    val test : IntentsTestRule<MainActivity> = IntentsTestRule(MainActivity::class.java)

    @Test
    fun Tester() {
        onView(withId(test.activity.ButFirst.id)).perform(click())
        onView(withId(test.activity.ButSecond.id)).perform(click())
        onView(withId(test.activity.ButFour.id)).perform(click())
        onView(withId(test.activity.ButFive.id)).perform(click())
        onView(withId(test.activity.ButSeven.id)).perform(click())

        intended(hasComponent(MainActivity2::class.java.name))

        onView(withId(R.id.Name)).check(matches(withText("Победил X!")))
    }
}