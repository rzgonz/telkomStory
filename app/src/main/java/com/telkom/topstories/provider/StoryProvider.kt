package com.telkom.topstories.provider


import com.telkom.common.clazz
import com.telkom.common.provider.BaseModuleProvider
import com.telkom.topstories.data.local.StoryLocalDataSource
import com.telkom.topstories.domain.StoryInteractor
import com.telkom.topstories.domain.StoryInteractorImpl
import com.telkom.topstories.domain.StoryRepository
import com.telkom.topstories.data.remote.StoryRemoteDataSource
import com.telkom.topstories.data.remote.StoryWebServices
import org.koin.core.module.Module
import org.koin.dsl.binds
import org.koin.dsl.module
import retrofit2.Retrofit

class StoryProvider private constructor() : BaseModuleProvider {

    override val modules: List<Module>
        get() = listOf(introModule, interactorModule)

    private val introModule = module {
        single {
            provideWebService(retrofit = get())
        }

        single {
            StoryRemoteDataSource(storyWebServices = get())
        }

        single {
            StoryLocalDataSource(basePreference = get())
        }

        single {
            StoryRepository(storyRemoveDataSource = get(), localDataSource = get())
        }


    }

    private val interactorModule = module {

        factory {
            StoryInteractorImpl(
                storyRepository = get(),
            )
        } binds arrayOf(StoryInteractor::class)
    }


    private fun provideWebService(retrofit: Retrofit) = retrofit.create(clazz<StoryWebServices>())

    companion object {

        @Volatile
        private var INSTANCE: StoryProvider? = null

        @JvmStatic
        fun getInstance(): StoryProvider {
            return INSTANCE ?: synchronized(clazz<StoryProvider>()) {
                return@synchronized StoryProvider()
            }.also {
                INSTANCE = it
            }
        }

    }


}