package com.telkom.topstories

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.telkom.topstories.domain.dto.StoryDto
import com.telkom.topstories.ext.addFragment
import com.telkom.topstories.ext.replaceFragment
import com.telkom.topstories.navigation.StoryScreenNavigator
import com.telkom.topstories.presentation.detail.DetailFragment
import com.telkom.topstories.presentation.main.MainFragment

class MainActivity : AppCompatActivity(), StoryScreenNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            homeScreen()
        }
    }

    private fun homeScreen() {
        replaceFragment<MainFragment>(
            containerViewId = R.id.container,
        )
    }

    override fun navigateToDetail(story: StoryDto) {
        replaceFragment<DetailFragment>(
            containerViewId = R.id.container,
            data = bundleOf(
                DetailFragment.DETAIL_ARGS to story
            ),
            isAddToBackStack = true
        )
    }
}