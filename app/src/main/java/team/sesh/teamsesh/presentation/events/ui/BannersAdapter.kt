package team.sesh.teamsesh.presentation.events.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_banner.view.*
import team.sesh.teamsesh.R
import team.sesh.teamsesh.models.Banner

class BannersAdapter(
    private val bannerClickListener: ((Banner) -> Unit)?
) : RecyclerView.Adapter<BannersAdapter.ViewHolder>() {

    private var banners = arrayListOf<Banner>()

    fun setData(banners: ArrayList<Banner>) {

        this.banners.run {
            clear()
            addAll(banners)
        }

        notifyDataSetChanged()
    }

    override fun getItemCount() = banners.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        view = LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false),
        bannerClickListener = bannerClickListener
    )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(banners[position])
    }

    inner class ViewHolder(
        view: View,
        private val bannerClickListener: ((Banner) -> Unit)?
    ) : RecyclerView.ViewHolder(view) {

        fun bindData(banner: Banner) {
            Picasso
                .get()
                .load(banner.imageBanners)
                .into(itemView.bannerImageView)

            itemView.setOnClickListener { bannerClickListener?.invoke(banner) }
        }
    }
}
