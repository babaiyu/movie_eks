package com.babaiyu.movieeks.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.babaiyu.movieeks.R
import com.babaiyu.movieeks.`interface`.CardList
import com.babaiyu.movieeks.components.CardListAdapter

class DashboardFragment : Fragment(), View.OnClickListener {

    override fun onClick(v: View) {}

    private lateinit var rvTVShow: RecyclerView
    private val listTVShow = ArrayList<CardList>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_dashboard, container, false)

        rvTVShow = rootView.findViewById(R.id.rv_tv_show)
        rvTVShow.setHasFixedSize(true)

        listTVShow.addAll(getListTVShows())
        showTVShows()

        return rootView
    }

    private fun getListTVShows(): ArrayList<CardList> {
        val tvTitle = resources.getStringArray(R.array.tv_title)
        val tvRelease = resources.getStringArray(R.array.tv_release)
        val tvDescription = resources.getStringArray(R.array.tv_description)
        val tvPhoto = resources.obtainTypedArray(R.array.tv_photo)

        val list = ArrayList<CardList>()
        for (index in tvTitle.indices) {
            val tv = CardList(
                tvTitle[index],
                tvRelease[index],
                tvDescription[index],
                tvPhoto.getResourceId(index, -1)
            )
            list.add(tv)
        }
        return list
    }

    private fun showTVShows() {
        rvTVShow.layoutManager = LinearLayoutManager(activity)
        val listTVShowAdapter = CardListAdapter(listTVShow)
        rvTVShow.adapter = listTVShowAdapter
    }
}