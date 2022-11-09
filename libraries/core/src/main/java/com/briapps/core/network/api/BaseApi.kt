package com.briapps.core.network.api

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class BaseApi @Inject constructor() {

    fun <Api> buildApi(
        api: Class<Api>
    ): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_API_MARVEL_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient())
            .build()
            .create(api)
    }

    private fun okHttpClient() : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .header("Authorization", PUBLIC_KEY_MARVEL)
                    .header("OS", OS)
                    .header("Content-Type", CONTENT_TYPE)
                    .header("Accept", ACCEPT)
                    .header("LOCALE", LOCALE)
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(httpLoggingInterceptor())
            .build()
    }

    private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor =
            HttpLoggingInterceptor { message ->
                Log.d(tag, "log: http log: $message")
            }
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    companion object {
        private const val OS = "ANDROID "
        private const val LOCALE = "pt-BR"
        private const val CONTENT_TYPE = "application/json"
        private const val ACCEPT = "application/json"
        private const val tag = "Okhttp"
        private const val PUBLIC_KEY_MARVEL = "a2c0bf7a8a4c36141681b7d8f12dabff"
        private const val PRIVATE_KEY_MARVEL = "d31e9cdbd25773aedd3f3681266365d33a0fc2b6"
        private const val BASE_API_MARVEL_URL = ""
    }
}