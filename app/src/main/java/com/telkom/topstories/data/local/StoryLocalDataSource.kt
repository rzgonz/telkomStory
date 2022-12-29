package com.telkom.topstories.data.local

import com.telkom.presistance.BasePreference


class StoryLocalDataSource(
    private val basePreference: BasePreference
) {

    fun saveString(key: StoryPrefKey, value: String) {
        basePreference.setString(key = key.value, value = value)
    }

    fun getString(key: StoryPrefKey) = basePreference.getString(key.value, "")

    enum class StoryPrefKey(val value: String) {
        STORY_FAV("contact_support"),
        TNC("t_n_c_link"),
        MAX_NIGHTS("MAX_NIGHTS")
    }
}