package com.babaiyu.movieeks.ui.dashboard

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.babaiyu.movieeks.DetailActivity
import com.babaiyu.movieeks.R
import com.babaiyu.movieeks.`interface`.DataDetail
import com.babaiyu.movieeks.components.CardListAdapter

class DashboardFragment : Fragment(), View.OnClickListener {

    override fun onClick(v: View) {}

    private lateinit var tvTitle: Array<String>
    private lateinit var tvRelease: Array<String>
    private lateinit var tvDescription: Array<String>
    private lateinit var tvScore: Array<String>
    private lateinit var tvDuration: Array<String>
    private lateinit var tvDirector: Array<String>
    private lateinit var tvCaster: Array<String>
    private lateinit var tvPhoto: TypedArray

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
        tvTitle = resources.getStringArray(R.array.tv_title)
        tvRelease = resources.getStringArray(R.array.tv_release)
        tvDescription = resources.getStringArray(R.array.tv_description)
        tvScore = resources.getStringArray(R.array.tv_score)
        tvDuration = resources.getStringArray(R.array.tv_duration)
        tvDirector = resources.getStringArray(R.array.tv_director)
        tvCaster = resources.getStringArray(R.array.tv_caster)
        tvPhoto = resources.obtainTypedArray(R.array.tv_photo)

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
            val detailIntent = Intent(context, DetailActivity::class.java)
            detailIntent.putExtra(DetailActivity.EXTRA_DATA, item)
            startActivity(detailIntent)
        }
    }
}