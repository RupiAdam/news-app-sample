package net.rupiadam.news.room

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NewsDao{

    @Query("SELECT * FROM news")
    fun news(): DataSource.Factory<Int, News>

    @Insert
    fun insert(vararg news: News)

    @Query("DELETE FROM news")
    fun deleteAll()
}