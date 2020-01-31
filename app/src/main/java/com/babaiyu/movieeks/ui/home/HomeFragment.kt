package com.babaiyu.movieeks.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.babaiyu.movieeks.DetailActivity
import com.babaiyu.movieeks.R
import com.babaiyu.movieeks.`interface`.DataDetail
import com.babaiyu.movieeks.components.CardListAdapter

class HomeFragment : Fragment(), View.OnClickListener {

    override fun onClick(v: View) {}

    private lateinit var rvMovies: RecyclerView
    private val listMovie = ArrayList<DataDetail>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_home, container, false)

        rvMovies = rootView.findViewById(R.id.rv_movies)
        rvMovies.setHasFixedSize(true)

        listMovie.addAll(getListMovie())
        showMovies()

        return rootView
    }

    private fun getListMovie(): ArrayList<DataDetail> {
        val movieTitle = resources.getStringArray(R.array.movie_title)
        val movieRelease = resources.getStringArray(R.array.movie_release)
        val movieDescription = resources.getStringArray(R.array.movie_description)
        val movieScore = resources.getStringArray(R.array.movie_score)
        val movieDuration = resources.getStringArray(R.array.movie_duration)
        val movieDirector = resources.getStringArray(R.array.movie_director)
        val movieCaster = resources.getStringArray(R.array.movie_caster)
        val moviePhoto = resources.obtainTypedArray(R.array.movie_photo)

        val list = ArrayList<DataDetail>()
        for (index in movieTitle.indices) {
            val movie = DataDetail(
                movieTitle[index],
                movieRelease[index],
                movieDescription[index],
                movieScore[index],
                movieDuration[index],
                movieDirector[index],
                movieCaster[index],
                moviePhoto.getResourceId(index, -1)
            )
            list.add(movie)
        }
        return list
    }

    private fun showMovies() {
        rvMovies.layoutManager = LinearLayoutManager(activity)
        val listMovieAdapter = CardListAdapter(listMovie)
        rvMovies.adapter = listMovieAdapter

        listMovieAdapter.onItemClick = { item ->
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