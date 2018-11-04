package net.rupiadam.news.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_news.view.*
import net.rupiadam.news.R
import net.rupiadam.news.room.News
import java.text.SimpleDateFormat

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>(){

    private lateinit var context: Context
    private var listNews = ArrayList<News>()
    private val dateFormat = SimpleDateFormat("d MMM yyyy")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_news, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listNews.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = listNews[position]

        holder.title.text = item.title
        holder.description.text = item.content
        holder.contributor.text = "${item.create_by}  •  ${dateFormat.format(item.create_date)}"

    }

    fun setNews(listNews: List<News>){
        this.listNews = listNews as ArrayList<News>
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val avatar      = itemView.findViewById<ImageView>(R.id.user_avatar)
        val title       = itemView.findViewById<TextView>(R.id.title)
        val description = itemView.findViewById<TextView>(R.id.description)
        val thumbnail   = itemView.findViewById<ImageView>(R.id.thumbnail)
        val contributor = itemView.findViewById<TextView>(R.id.contributor)
        val parent      = itemView.findViewById<LinearLayout>(R.id.parent)
    }

}