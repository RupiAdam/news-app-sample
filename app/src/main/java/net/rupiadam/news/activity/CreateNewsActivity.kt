package net.rupiadam.news.activity

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import net.rupiadam.news.R

import kotlinx.android.synthetic.main.activity_create_news.*

class CreateNewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_news)
        setSupportActionBar(toolbar)

    }

}
