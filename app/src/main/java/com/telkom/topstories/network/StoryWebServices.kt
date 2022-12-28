package com.telkom.topstories.network

import com.telkom.topstories.data.remote.response.CommentResponse
import com.telkom.topstories.data.remote.response.StoryResponse
import retrofit2.http.GET
import retrofit2.http.Path

//    https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty

interface StoryWebServices {

    @GET("topstories.json")
    suspend fun getListStory():List<String>

    @GET("item/{story_id}.json")
    suspend fun getStory(
        @Path("story_id") storyId: String
    ):StoryResponse

    @GET("item/{comment_id}.json")
    suspend fun getComment(
        @Path("comment_id") commentId: String
    ):CommentResponse


}