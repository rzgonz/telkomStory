package com.telkom.topstories.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.telkom.topstories.domain.StoryInteractor
import com.telkom.topstories.domain.dto.StoryDto
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainViewModel : ViewModel(), KoinComponent {
    private val storyInteractor: StoryInteractor by inject()
    private val listStory:ArrayList<StoryDto> = arrayListOf()
    val liveDataIsLoading = MutableLiveData<Boolean>()
    val liveDataStory = MutableLiveData<ArrayList<StoryDto>>()

    fun getTopStory() {
        viewModelScope.launch {
            liveDataIsLoading.postValue(true)
            try {
                storyInteractor.getTopStory().take(10).map {
                    try {
                        val data = storyInteractor.getStory(it)
                        listStory.add(data)
                        liveDataStory.postValue(listStory)
                    }catch (e:Exception){

                    }
                }
                liveDataIsLoading.postValue(false)
            } catch (e: Exception) {

            }
        }
    }
}