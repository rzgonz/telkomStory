package com.telkom.topstories.domain

import com.google.gson.Gson
import com.telkom.common.clazz
import com.telkom.common.utils.safeLaunchWithResult
import com.telkom.topstories.data.local.StoryLocalDataSource
import com.telkom.topstories.data.remote.StoryRemoteDataSource
import com.telkom.topstories.domain.dto.StoryDto

class StoryRepository(
    private val storyRemoveDataSource: StoryRemoteDataSource,
    private val localDataSource: StoryLocalDataSource
) {
    suspend fun getTopStory() = storyRemoveDataSource.getListStory()
    suspend fun getStory(storyId: String) = storyRemoveDataSource.getStory(storyId)
    suspend fun getComment(commentId: String) = storyRemoveDataSource.getComment(commentId)

    var storyFav: StoryDto
        get() {
          return safeLaunchWithResult(StoryDto()) {
                Gson().fromJson(
                    localDataSource.getString(StoryLocalDataSource.StoryPrefKey.STORY_FAV),
                    clazz<StoryDto>()
                )
            }
        }
        set(story) {
            localDataSource.saveString(
                StoryLocalDataSource.StoryPrefKey.STORY_FAV,
                Gson().toJson(story)
            )
        }
}