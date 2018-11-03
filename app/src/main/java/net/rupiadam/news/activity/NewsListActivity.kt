package net.rupiadam.news.activity

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_news_list.*
import net.rupiadam.news.R

class NewsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)
        setSupportActionBar(toolbar)



    }

}
