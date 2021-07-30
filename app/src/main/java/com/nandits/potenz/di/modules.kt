package com.nandits.potenz.di

import com.nandits.potenz.data.local.UserPreference
import com.nandits.potenz.ui.adapter.CardItemAdapter
import com.nandits.potenz.ui.adapter.ChoiceAdapter
import com.nandits.potenz.ui.choice.ChoiceViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {
    single { UserPreference(androidContext()) }
}

val viewModelModule = module {
    single { ChoiceViewModel() }
}

val adapterModule = module {
    factory { CardItemAdapter() }
    factory { ChoiceAdapter() }
}