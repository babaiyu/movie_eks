package com.babaiyu.movieeks

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.babaiyu.movieeks.`interface`.DataDetail
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val detail = intent.getParcelableExtra(EXTRA_DATA) as DataDetail
        title = detail.title
        detailTitle.text = detail.title
        detailScore.text = detail.score
        detailRelease.text = detail.release
        detailDuration.text = detail.duration
        detailDirector.text = detail.director
        detailDescription.text = detail.description
        detailCaster.text = detail.caster
        Glide.with(detailImage)
            .load(detail.photo)
            .into(detailImage)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onClick(v: View?) {}
}
