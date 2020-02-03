package com.babaiyu.movieeks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
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
        detail_title.text = detail.title
        detail_score.text = "${detail.score}%"
        detail_release.text = detail.release
        detail_duration.text = detail.duration
        detail_director.text = detail.director
        detail_description.text = detail.description
        detail_caster.text = detail.caster
        Glide.with(detail_image)
            .load(detail.photo)
            .into(detail_image)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onClick(v: View?) {}
}
