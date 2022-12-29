package com.telkom.topstories.domain

import com.telkom.topstories.domain.dto.CommentDto
import com.telkom.topstories.domain.dto.StoryDto

class StoryInteractorImpl(
    private val storyRepository: StoryRepository
) : StoryInteractor {
    override suspend fun getTopStory(): List<String> {
        return storyRepository.getTopStory()
    }

    override suspend fun getStory(storyId: String): StoryDto {
        return StoryDataMapper.storyResponseToDto(storyRepository.getStory(storyId))
    }

    override suspend fun getComment(commentId: String): CommentDto {
        return StoryDataMapper.commentResponseToDto(storyRepository.getComment(commentId))
    }

    override fun getFavStory(): StoryDto = storyRepository.storyFav

    override fun setFavStory(storyDto: StoryDto) {
        storyRepository.storyFav = storyDto
    }
}