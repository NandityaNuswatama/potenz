package com.nandits.potenz.data.local

import android.content.Context
import com.nandits.potenz.utils.PREF_NAME

class UserPreference(private val context: Context) {
    private val preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
}