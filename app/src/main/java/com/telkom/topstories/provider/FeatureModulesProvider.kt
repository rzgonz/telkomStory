package com.telkom.topstories.provider


import org.koin.core.module.Module

object FeatureModulesProvider {

    val featureModules: List<Module>
        get() {
            return collectAll(
                StoryProvider.getInstance().modules
            )
        }

    private fun collectAll(vararg modules: List<Module>): List<Module> {
        if (modules.isNullOrEmpty()) return emptyList()

        val resList = mutableListOf<Module>()
        modules.forEach { module ->
            resList.plusAssign(module)
        }
        return resList.toList()
    }
}