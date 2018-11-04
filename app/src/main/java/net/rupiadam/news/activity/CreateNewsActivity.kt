package net.rupiadam.news.activity

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders
import net.rupiadam.news.R

import kotlinx.android.synthetic.main.activity_create_news.*
import kotlinx.android.synthetic.main.content_create_news.*
import net.rupiadam.news.DialogBuilder
import net.rupiadam.news.room.News
import net.rupiadam.news.room.NewsViewModel
import java.util.*

class CreateNewsActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(NewsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_news)
        setSupportActionBar(toolbar)

        button_save.setOnClickListener {

            val tittle  = input_title.text.toString()
            val content = input_content.text.toString()
            val image   = input_image.text.toString()

            if (tittle.isEmpty() || content.isEmpty() || image.isEmpty())
                DialogBuilder(this,"", "Lengkapi seluruh kolom").show_and_dismiss()
            else{
                val cal = Calendar.getInstance()
                val news = News(image, tittle, content, cal.timeInMillis, "Rupi Adam")
                viewModel.insert(news)
                DialogBuilder(this, "", "Data berhasil disimpan").show_and_finish()
            }

        }

    }

}
