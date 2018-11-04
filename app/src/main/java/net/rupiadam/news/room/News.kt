package net.rupiadam.news.room

import java.io.Serializable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
class News(

        @field:ColumnInfo(name = "featured_image")
           var featured_image: String,

        @field:ColumnInfo(name = "title")
           var title: String,

        @field:ColumnInfo(name = "content")
           var content: String,

        @field:ColumnInfo(name = "create_date")
           var create_date: Long?,

        @field:ColumnInfo(name = "create_by")
           var create_by: String) : Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}
