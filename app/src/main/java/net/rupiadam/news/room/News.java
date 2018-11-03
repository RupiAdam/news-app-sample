package net.rupiadam.news.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "news")
public class News {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "featured_image")
    public String featured_image;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "content")
    public String content;

    @ColumnInfo(name = "create_date")
    public Long create_date;

    @ColumnInfo(name = "create_by")
    public String create_by;

    public News(@NonNull int id, String featured_image, String title, String content, Long create_date, String create_by) {
        this.id = id;
        this.featured_image = featured_image;
        this.title = title;
        this.content = content;
        this.create_date = create_date;
        this.create_by = create_by;
    }
}
