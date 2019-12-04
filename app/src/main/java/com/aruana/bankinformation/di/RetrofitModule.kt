package com.aruana.bankinformation.di

import com.aruana.bankinformation.networking.BankService
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object RetrofitModule {

    @Provides
    @Singleton
    fun provideBankService(): BankService = Retrofit.Builder()
            .baseUrl(BankService.API_ENDPOINT)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(getOkHttpClient())
            .build()
            .create(BankService::class.java)

    @Provides
    @Singleton
    fun getOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor { chain ->
            val credentials = Credentials.basic(BankService.USER_NAME, BankService.PASSWORD)
            val newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", credentials)
                    .build()
            chain.proceed(newRequest)
        }

        return builder.build()
    }
}