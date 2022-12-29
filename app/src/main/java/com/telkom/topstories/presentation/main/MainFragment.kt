package com.telkom.topstories.presentation.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.telkom.common.logD
import com.telkom.topstories.R
import com.telkom.topstories.domain.dto.StoryDto
import com.telkom.topstories.navigation.StoryScreenNavigator
import com.telkom.topstories.utils.DiffCallback
import com.telkom.topstories.utils.GenericRecyclerAdapter

class MainFragment : Fragment() {
    private var screenNavigator: StoryScreenNavigator? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is StoryScreenNavigator) {
            screenNavigator = context
        } else {
            throw ClassCastException("interface not attached")
        }
    }

    private lateinit var progressBar: LinearProgressIndicator

    private lateinit var recyclerViewStory: RecyclerView

    private lateinit var viewHeader: LinearLayout

    private lateinit var textFavTitle: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        recyclerViewStory = view.findViewById(R.id.recyclerViewStory)
        textFavTitle = view.findViewById(R.id.textViewFavTitle)
        viewHeader = view.findViewById(R.id.view_header_fav)
        progressBar = view.findViewById(R.id.progress_horizontal)
        return view
    }

    private val viewModel: MainViewModel by viewModels()

    private val adapterStory by lazy {
        GenericRecyclerAdapter<StoryDto>(
            diffCallback = DiffCallback(),
            holderResId = R.layout.story_view_cell,
            onBind = { data, view ->
                view.findViewById<TextView>(R.id.cellTitle).text = data.title
                view.findViewById<TextView>(R.id.cellCommentCount).text =
                    "Total Comment : ${data.kids.size}"
                view.findViewById<TextView>(R.id.cellSocre).text = "Score : ${data.score}"
            },
            itemListener = { data, _, _ ->
                screenNavigator?.navigateToDetail(data)
            }
        )
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeListStory()
        subscribeIsLoading()
        initViewData()
        checkFavData()
    }

    private fun initViewData() {
        viewModel.getTopStory()
        recyclerViewStory.run {
            adapter = adapterStory
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getFavStory()
    }

    private fun checkFavData() {
        viewModel.liveDataFavStory.observe(viewLifecycleOwner) {
            if (it.title.isNotEmpty()) {
                viewHeader.visibility = View.VISIBLE
                textFavTitle.text = it.title
            } else {
                viewHeader.visibility = View.GONE
            }
        }
    }

    private fun subscribeIsLoading() {
        viewModel.liveDataIsLoading.observe(viewLifecycleOwner) {
            progressBar.visibility = if (it) View.VISIBLE else View.INVISIBLE
        }
    }

    private fun subscribeListStory() {
        viewModel.liveDataStory.observe(viewLifecycleOwner) {
            adapterStory.setData(it)
        }
    }

}