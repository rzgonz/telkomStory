package com.telkom.common.config

import com.telkom.common.provider.BaseModuleProvider
import com.telkom.common.clazz
import org.koin.core.module.Module
import org.koin.dsl.module


class CommonBuildConfigProvider private constructor(private val configClassName: String) :
    BaseModuleProvider {

    override val modules: List<Module>
        get() = listOf(
            commonBuildConfigModule
        )

    private val commonBuildConfigModule = module {
        single { CommonBuildConfig(configClassName) }
    }

    companion object {

        @Volatile
        private var INSTANCE: CommonBuildConfigProvider? = null

        @JvmStatic
        fun getInstance(configClassName: String): CommonBuildConfigProvider {
            return INSTANCE ?: synchronized(clazz<CommonBuildConfigProvider>()) {
                return@synchronized CommonBuildConfigProvider(configClassName)
            }.also {
                INSTANCE = it
            }
        }

    }
}