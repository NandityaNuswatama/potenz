package com.nandits.potenz.di

import com.nandits.potenz.data.Repository
import com.nandits.potenz.data.local.UserPreference
import com.nandits.potenz.data.remote.ApiService
import com.nandits.potenz.data.remote.RemoteDataSource
import com.nandits.potenz.ui.adapter.CardItemAdapter
import com.nandits.potenz.ui.adapter.MultiSelectAdapter
import com.nandits.potenz.ui.choice.ChoiceViewModel
import com.nandits.potenz.ui.home.HomeViewModel
import com.nandits.potenz.ui.profile.ProfileViewModel
import com.nandits.potenz.ui.start.LoginViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val localModule = module {
    single { UserPreference(androidContext()) }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://potenz-default-rtdb.asia-southeast1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { RemoteDataSource(get()) }
    single { Repository(get(), get()) }
}

val viewModelModule = module {
    single { HomeViewModel(get())}
    single { ChoiceViewModel() }
    single { LoginViewModel(get()) }
    single { ProfileViewModel(get())}
}

val adapterModule = module {
    factory { MultiSelectAdapter() }
}