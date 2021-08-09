package team.sesh.teamsesh.presentation.home.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news.view.*
import team.sesh.teamsesh.R
import team.sesh.teamsesh.models.News


class NewsAdapter(
    private val newsClickListener: ((News)-> Unit)?
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var news = arrayListOf<News>()

    fun setData(banners: ArrayList<News>){

        this.news.run {
            clear()
            addAll(banners)
        }

        notifyDataSetChanged()
    }

    // Gets the number of news in the list
    override fun getItemCount() = news.size

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
          view =   LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false),
        newsClickListener = newsClickListener
        )

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(news[position])
    }

    inner class ViewHolder(view: View,
      private val newsClickListener: ((News)-> Unit)?

    ) : RecyclerView.ViewHolder(view) {

        fun bindData(type: News) {
            itemView.titleView.text = type.title
//            itemView.descriptionView.text = type.description
//            itemView.button1.tag = type.link
            Log.e("DATA", "error")



            Picasso
                .get()
                .load(type.image)
                .placeholder(R.drawable.teamsesh)
                .into(itemView.newsImage)
//                    object : Target {
//                    override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
//
//                    }
//
//                    override fun onBitmapFailed(e: java.lang.Exception?, errorDrawable: Drawable?) {
//                    }
//
//                    override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
//                        itemView.newsImage.setImageBitmap(bitmap)
//                    }
//                }
//
//                )
            itemView.setOnClickListener { newsClickListener?.invoke(type) }

        }
    }

}
