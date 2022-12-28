package com.telkom.topstories.navigation

import com.telkom.topstories.domain.dto.StoryDto

interface StoryScreenNavigator {
    fun navigateToDetail(story:StoryDto)
}
