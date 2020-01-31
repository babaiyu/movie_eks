package com.babaiyu.movieeks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.babaiyu.movieeks.`interface`.DataDetail
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detail = intent.getParcelableExtra(EXTRA_DATA) as DataDetail
        title = detail.title
        detail_title.text = detail.title
    }
}
