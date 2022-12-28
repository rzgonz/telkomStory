package com.telkom.topstories

import android.app.Application
import com.telkom.common.config.CommonBuildConfig
import com.telkom.network.NetworkUtils
import com.telkom.topstories.provider.AppModulesProvider
import com.telkom.topstories.provider.FeatureModulesProvider
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module


open class Applications : Application() {

    private val defaultPackageName: String by lazy { this.packageName }
    private val networkUtils: NetworkUtils by inject()
    private val commonBuildConfig: CommonBuildConfig by inject()


    private val configClassName: String by lazy {
        BuildConfig::class.java.`package`.name.orEmpty() + ".BuildConfig"
    }

    override fun onCreate() {
        super.onCreate()
        setupKoin()
        networkUtils.setBaseUrl(
           " https://hacker-news.firebaseio.com/v0/"
        )

    }

    private fun setupKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@Applications)

            modules(mutableListOf<Module>().apply {
                addAll(
                    AppModulesProvider.getInstance(
                        isDebug = BuildConfig.DEBUG,
                        defaultPackageName = defaultPackageName,
                        configClassName = configClassName
                    ).appModules
                )
                plusAssign(FeatureModulesProvider.featureModules)
            })
        }
    }




}