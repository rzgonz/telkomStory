package com.telkom.topstories.domain

import com.telkom.common.orZero
import com.telkom.common.toTimeDateString
import com.telkom.topstories.data.remote.response.CommentResponse
import com.telkom.topstories.data.remote.response.StoryResponse
import com.telkom.topstories.domain.dto.CommentDto
import com.telkom.topstories.domain.dto.StoryDto

object StoryDataMapper {
    fun storyResponseToDto(response:StoryResponse?)= StoryDto(
        score = response?.score.orZero(),
        by = response?.by.orEmpty(),
        id = response?.id.orZero(),
        time =  response?.time.orZero().toTimeDateString(),
        title = response?.title.orEmpty(),
        type = response?.type.orEmpty(),
        descendants = response?.descendants.orZero(),
        url = response?.url.orEmpty(),
        kids = response?.kids?.map { it.orZero() }.orEmpty()
    )

    fun commentResponseToDto(response:CommentResponse?) =
        CommentDto(
            parent = response?.parent.orZero(),
            by =  response?.by.orEmpty(),
            id = response?.id.orZero(),
            text = response?.text.orEmpty(),
            time = response?.time.orZero().toTimeDateString(),
            type = response?.type.orEmpty(),
            kids = response?.kids?.map { it.orZero() }.orEmpty()
        )

}