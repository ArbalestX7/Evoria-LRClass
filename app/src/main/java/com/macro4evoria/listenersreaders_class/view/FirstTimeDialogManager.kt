package com.macro4evoria.listenersreaders_class.view

import android.content.Context
import android.content.SharedPreferences

class FirstTimeDialogManager(private val context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPreference", Context.MODE_PRIVATE)
    private val isFirstTimeKey = "isFirstTime"

    fun shouldShowDialog(): Boolean {
        return sharedPreferences.getBoolean(isFirstTimeKey, true)
    }

    fun setDialogShown() {
        sharedPreferences.edit().putBoolean(isFirstTimeKey, false).apply()
    }
}
