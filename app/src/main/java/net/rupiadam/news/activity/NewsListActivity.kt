package net.rupiadam.news.activity

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_news_list.*
import kotlinx.android.synthetic.main.content_news_list.*
import net.rupiadam.news.R
import net.rupiadam.news.adapter.NewsAdapter
import net.rupiadam.news.room.NewsViewModel

class NewsListActivity : AppCompatActivity() {

    private lateinit var adapter: NewsAdapter
    private val newsVM by lazy {
        ViewModelProviders.of(this).get(NewsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            startActivity(Intent(this, CreateNewsActivity::class.java))
        }

        adapter = NewsAdapter()
        recycler.adapter = adapter

        newsVM.getAllNews().observe(this, Observer {
            listNews ->
            adapter.setNews(listNews)
        })

    }

}
