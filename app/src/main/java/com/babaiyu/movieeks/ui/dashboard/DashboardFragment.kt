package com.babaiyu.movieeks.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.babaiyu.movieeks.DetailActivity
import com.babaiyu.movieeks.R
import com.babaiyu.movieeks.`interface`.CardList
import com.babaiyu.movieeks.`interface`.DataDetail
import com.babaiyu.movieeks.components.CardListAdapter

class DashboardFragment : Fragment(), View.OnClickListener {

    override fun onClick(v: View) {}

    private lateinit var rvTVShow: RecyclerView
    private val listTVShow = ArrayList<DataDetail>()

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

    private fun getListTVShows(): ArrayList<DataDetail> {
        val tvTitle = resources.getStringArray(R.array.tv_title)
        val tvRelease = resources.getStringArray(R.array.tv_release)
        val tvDescription = resources.getStringArray(R.array.tv_description)
        val tvScore = resources.getStringArray(R.array.tv_score)
        val tvDuration = resources.getStringArray(R.array.tv_duration)
        val tvDirector = resources.getStringArray(R.array.tv_director)
        val tvCaster = resources.getStringArray(R.array.tv_caster)
        val tvPhoto = resources.obtainTypedArray(R.array.tv_photo)

        val list = ArrayList<DataDetail>()
        for (index in tvTitle.indices) {
            val tv = DataDetail(
                tvTitle[index],
                tvRelease[index],
                tvDescription[index],
                tvScore[index],
                tvDuration[index],
                tvDirector[index],
                tvCaster[index],
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

        listTVShowAdapter.onItemClick = { item ->
            val dataIntent = DataDetail(
                item.title,
                item.release,
                item.description,
                item.score,
                item.duration,
                item.director,
                item.caster,
                item.photo
            )
            val detailIntent = Intent(context, DetailActivity::class.java)
            detailIntent.putExtra(DetailActivity.EXTRA_DATA, dataIntent)
            startActivity(detailIntent)
        }
    }
}