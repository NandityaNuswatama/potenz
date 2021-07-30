package com.nandits.potenz.di

import com.nandits.potenz.data.local.UserPreference
import com.nandits.potenz.ui.adapter.CardItemAdapter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {
    single { UserPreference(androidContext()) }
}

val adapterModule = module {
    factory { CardItemAdapter() }
}