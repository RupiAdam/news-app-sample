package net.rupiadam.news.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.app.Activity
import android.graphics.PorterDuff
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import net.rupiadam.news.R

import kotlinx.android.synthetic.main.activity_detail_news.*
import net.rupiadam.news.GlideApp
import net.rupiadam.news.room.News
import java.text.SimpleDateFormat

class DetailNewsActivity : AppCompatActivity() {

    private val dateFormat = SimpleDateFormat("d MMM yyyy")

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)
        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val upArrow = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back_black)
        upArrow!!.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP)
        supportActionBar!!.setHomeAsUpIndicator(upArrow)

        val news = intent.getSerializableExtra("news") as News
        supportActionBar!!.title = news.title
        news_title.text = news.title
        description.text = news.content
        contributor.text = "${news.create_by}  •  ${dateFormat.format(news.create_date)}"

        GlideApp.with(this).load(news.featured_image).into(feature_image)
        GlideApp.with(this).load(R.drawable.default_avatar).circleCrop().into(user_avatar)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
