package com.example.assignment.utils
import android.util.Log

object TestLogger {
    private const val TAG = "TestLogger"

    fun info(message: String) {
        Log.i(TAG, message)
    }

    fun error(message: String) {
        Log.e(TAG, message)
    }
}
