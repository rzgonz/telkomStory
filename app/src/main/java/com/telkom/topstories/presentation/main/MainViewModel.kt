package com.telkom.topstories.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.telkom.common.orZero
import com.telkom.topstories.domain.StoryInteractor
import com.telkom.topstories.domain.dto.StoryDto
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainViewModel : ViewModel(), KoinComponent {
    private val storyInteractor: StoryInteractor by inject()
    val liveDataIsLoading = MutableLiveData<Boolean>()
    val liveDataStory = MutableLiveData<ArrayList<StoryDto>>()
    val liveDataFavStory = MutableLiveData<StoryDto>()

    init {
        getFavStory()
    }

    fun getFavStory() {
        liveDataFavStory.postValue(storyInteractor.getFavStory())
    }

    fun getTopStory() {
        viewModelScope.launch {
            liveDataIsLoading.postValue(true)
            try {
                val data = storyInteractor.getTopStory()
                val dataCount = data.size
                data.takeIf { it.size > liveDataStory.value?.size.orZero() }
                    ?.takeLast(dataCount - liveDataStory.value?.size.orZero())
                    ?.chunked(20)?.forEach {
                        val listStory: ArrayList<StoryDto> = arrayListOf()
                        it.map { serial ->
                            try {
                                val data = storyInteractor.getStory(serial)
                                listStory.add(data)
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                        liveDataStory.postValue(listStory)
                    }
                liveDataIsLoading.postValue(false)
            } catch (e: Exception) {
                liveDataIsLoading.postValue(false)
            }
        }
    }
}