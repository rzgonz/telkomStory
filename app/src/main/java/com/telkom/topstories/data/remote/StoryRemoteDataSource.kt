package com.telkom.topstories.data.remote

import com.telkom.topstories.data.remote.response.CommentResponse
import com.telkom.topstories.data.remote.response.StoryResponse

class StoryRemoteDataSource(
    private val storyWebServices: StoryWebServices
) : StoryWebServices {

    override suspend fun getListStory(): List<String> =
        storyWebServices.getListStory()


    override suspend fun getStory(storyId: String): StoryResponse =
        storyWebServices.getStory(storyId)

    override suspend fun getComment(commentId: String): CommentResponse =
        storyWebServices.getComment(commentId)


}