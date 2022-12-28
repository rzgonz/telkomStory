package com.telkom.topstories.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.telkom.topstories.domain.StoryInteractor
import com.telkom.topstories.domain.dto.CommentDto
import com.telkom.topstories.domain.dto.StoryDto
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DetailViewModel : ViewModel(), KoinComponent {
    private val storyInteractor: StoryInteractor by inject()
    private val listStory:ArrayList<CommentDto> = arrayListOf()
    val liveDataIsLoading = MutableLiveData<Boolean>()
    val liveDataStory = MutableLiveData<ArrayList<CommentDto>>()

    fun getListComment(storyDto: StoryDto) {
        viewModelScope.launch {
            liveDataIsLoading.postValue(true)
            try {
                storyDto.kids.map {
                    try {
                        val data = storyInteractor.getComment(it.toString())
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