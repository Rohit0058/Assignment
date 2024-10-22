package com.example.assignment.utils

import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import java.util.concurrent.TimeUnit

object TestUtils {
    lateinit var composeTestRule: ComposeTestRule

    fun waitFor(seconds: Int) {
        try {
            TimeUnit.SECONDS.sleep(seconds.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    fun initializeTestRule() {
        composeTestRule = createComposeRule()
    }
}
