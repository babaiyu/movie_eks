package com.babaiyu.movieeks.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.babaiyu.movieeks.R
import com.babaiyu.movieeks.`interface`.MovieList
import com.babaiyu.movieeks.components.CardListAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), View.OnClickListener {

    override fun onClick(v: View) {}

    private lateinit var rvMovies: RecyclerView
    private val listMovie = ArrayList<MovieList>()

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

    private fun getListMovie(): ArrayList<MovieList> {
        val movieTitle = resources.getStringArray(R.array.movie_title)
        val movieRelease = resources.getStringArray(R.array.movie_release)
        val movieDescription = resources.getStringArray(R.array.movie_description)
        val moviePhoto = resources.obtainTypedArray(R.array.movie_photo)

        val list = ArrayList<MovieList>()
        for (index in movieTitle.indices) {
            val movie = MovieList(
                movieTitle[index],
                movieRelease[index],
                movieDescription[index],
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
    }
}