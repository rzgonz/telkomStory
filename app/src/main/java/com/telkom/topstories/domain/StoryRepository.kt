package com.telkom.topstories.domain

import com.telkom.topstories.network.StoryRemoteDataSource

class StoryRepository(
    private val storyRemoveDataSource: StoryRemoteDataSource
) {
    suspend fun getTopStory() = storyRemoveDataSource.getListStory()
    suspend fun getStory(storyId:String) = storyRemoveDataSource.getStory(storyId)
    suspend fun getComment(commentId:String) = storyRemoveDataSource.getComment(commentId)

}