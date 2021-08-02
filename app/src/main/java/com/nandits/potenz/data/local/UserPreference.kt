package com.nandits.potenz.data.local

import android.content.Context
import androidx.core.content.edit
import com.nandits.potenz.data.model.UserModel
import com.nandits.potenz.utils.NONE
import com.nandits.potenz.utils.PREF_NAME

class UserPreference(private val context: Context) {
    companion object{
        const val NAME = "name"
        const val LEVEL = "level"
        const val SUBSCRIBE = "subscribe"
    }
    private val preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    
    fun saveUser(user: UserModel) = preferences.edit {
        putString(NAME, user.name)
        putString(LEVEL, user.level)
        putString(SUBSCRIBE, user.subscription)
    }
    
    fun updateTicket(num: String) = preferences.edit {
        putString(SUBSCRIBE, num)
    }
    
    fun eraseData() = preferences.edit {
        remove(NAME)
        remove(LEVEL)
    }
    
    fun getName() = preferences.getString(NAME,"")
    fun getTicket() = preferences.getString(SUBSCRIBE, NONE)
}