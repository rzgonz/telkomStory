package com.telkom.network

import com.telkom.common.config.CommonBuildConfig
import com.telkom.common.logI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkModule : KoinComponent {

    private val commonBuildConfig: CommonBuildConfig by inject()
    private val networkUtils: NetworkUtils by inject()

    private var requestTimeOut = 120L


    private val builder by lazy {
        logI<NetworkModule>("Init network")
        OkHttpClient.Builder()
    }

    fun getRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(networkUtils.getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    fun getClient(): OkHttpClient {
        val logInterceptor = HttpLoggingInterceptor().apply {
            logI<NetworkModule>("is debug ${commonBuildConfig.isDebug()}")
            level = if (commonBuildConfig.isDebug()) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }

        val httpClient = builder.apply {
            applyTrustManagerOkHttp()
          //  certificatePinner(createCertificatePinier())
            addNetworkInterceptor(logInterceptor)
            callTimeout(requestTimeOut, TimeUnit.SECONDS)
            connectTimeout(requestTimeOut, TimeUnit.SECONDS)
            readTimeout(requestTimeOut, TimeUnit.SECONDS)
            writeTimeout(requestTimeOut, TimeUnit.SECONDS)
        }

        return httpClient.build()
    }

}