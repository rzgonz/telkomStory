package com.telkom.topstories.domain.dto

data class CommentDto(
    val parent: Int = 0,
    val by: String = "",
    val id: Int = 0,
    val text: String = "",
    val time: String = "",
    val type: String = "",
    val kids: List<Int> = listOf()
)
