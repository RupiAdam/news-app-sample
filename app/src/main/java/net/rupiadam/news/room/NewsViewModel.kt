package net.rupiadam.news.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NewsViewModel(application: Application) : AndroidViewModel(application){

    val db = AppDatabase.getDatabase(application)
    val dao = db.newsDao()
    private val allNews: LiveData<List<News>>

    init {
        allNews = dao.news()
    }

    fun getAllNews(): LiveData<List<News>>{
        return allNews
    }

    fun insert(news: News) = ioThread{
        dao.insert(news)
    }

    fun deleteAll() = ioThread {
        dao.deleteAll()
    }
}