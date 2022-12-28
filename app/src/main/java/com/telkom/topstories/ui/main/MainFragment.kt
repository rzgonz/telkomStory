package com.telkom.topstories.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.telkom.topstories.R
import com.telkom.topstories.domain.dto.StoryDto
import com.telkom.topstories.navigation.StoryScreenNavigator
import com.telkom.topstories.utils.DiffCallback
import com.telkom.topstories.utils.GenericRecyclerAdapter

class MainFragment : Fragment() {
    private var screenNavigator : StoryScreenNavigator? = null
    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is StoryScreenNavigator) {
            screenNavigator = context
        } else {
            throw ClassCastException("interface not attached")
        }
    }


    private val viewModel: MainViewModel by viewModels()

    private val adapterStory by lazy {
        GenericRecyclerAdapter<StoryDto>(
            diffCallback = DiffCallback(),
            holderResId = R.layout.story_view_cell,
            onBind = { data, view ->
                view.findViewById<TextView>(R.id.cellTitle).text = data.title
                view.findViewById<TextView>(R.id.cellCommentCount).text =
                    "Total Comment : ${data.descendants}"
                view.findViewById<TextView>(R.id.cellSocre).text = "Score : ${data.score}"
            },
            itemListener = { data, _, _ ->
            screenNavigator?.navigateToDetail(data)
            }
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    private val progressBar by lazy {
        view?.findViewById<LinearProgressIndicator>(R.id.progress_horizontal)
    }

    private val recyclerViewStory by lazy {
        view?.findViewById<RecyclerView>(R.id.recyclerViewStory)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.message).setOnClickListener {

        }
        subscribeListStory()
        subscribeIsLoading()
        initViewData()
    }

    private fun initViewData() {
        viewModel.getTopStory()
        recyclerViewStory?.run {
            adapter = adapterStory
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    private fun subscribeIsLoading() {
        viewModel.liveDataIsLoading.observe(viewLifecycleOwner) {
            progressBar?.visibility = if (it) View.VISIBLE else View.GONE
        }
    }

    private fun subscribeListStory() {
        viewModel.liveDataStory.observe(viewLifecycleOwner) {
            adapterStory.setData(it)
            view?.findViewById<TextView>(R.id.message)?.text = "SIZE LIST = ${it?.size}"
        }
    }

}