package com.telkom.topstories.domain

import com.telkom.topstories.domain.dto.CommentDto
import com.telkom.topstories.domain.dto.StoryDto

interface StoryInteractor {
    suspend fun getTopStory(): List<String>
    suspend fun getStory(storyId: String): StoryDto
    suspend fun getComment(commentId: String): CommentDto
}