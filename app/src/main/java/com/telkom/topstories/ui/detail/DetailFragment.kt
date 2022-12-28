package com.telkom.topstories.ui.detail

import android.os.Bundle
import android.text.Html
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
import com.telkom.topstories.domain.dto.CommentDto
import com.telkom.topstories.domain.dto.StoryDto
import com.telkom.topstories.ui.main.MainViewModel
import com.telkom.topstories.utils.DiffCallback
import com.telkom.topstories.utils.GenericRecyclerAdapter

class DetailFragment : Fragment() {

    private val argDetail:StoryDto by lazy {
        arguments?.getParcelable(DETAIL_ARGS) ?: StoryDto()
    }

    private val viewModel: DetailViewModel by viewModels()


    private val adapterStory by lazy {
        GenericRecyclerAdapter<CommentDto>(
            diffCallback = DiffCallback(),
            holderResId = R.layout.comment_view_cell,
            onBind = { data, view ->
                view.findViewById<TextView>(R.id.cellTitle).text = Html.fromHtml(data.text)
            },
            itemListener = { data, _, _ ->

            }
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_detail, container, false)
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
        subscribeListComment()
        subscribeIsLoading()
        initViewData()
    }

    private fun initViewData() {
        viewModel.getListComment(argDetail)
        recyclerViewStory?.run {
            adapter = adapterStory
            layoutManager = GridLayoutManager(context, 1)
        }
    }

    private fun subscribeIsLoading() {
        viewModel.liveDataIsLoading.observe(viewLifecycleOwner) {
            progressBar?.visibility = if (it) View.VISIBLE else View.GONE
        }
    }

    private fun subscribeListComment() {
        viewModel.liveDataStory.observe(viewLifecycleOwner) {
            adapterStory.setData(it)
            view?.findViewById<TextView>(R.id.message)?.text = "SIZE LIST = ${it.size}"
        }
    }

    companion object {
        const val DETAIL_ARGS = "DETAIL_ARGS"
    }


}