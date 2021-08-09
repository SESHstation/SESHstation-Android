package team.sesh.teamsesh.presentation.merch.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_merch.view.*
import team.sesh.teamsesh.R
import team.sesh.teamsesh.models.Merch


class MerchAdapter(
    private val itemWidth: Int
) : RecyclerView.Adapter<MerchAdapter.ViewHolder>() {

    private var merch = arrayListOf<Merch>()

    fun setData(banners: ArrayList<Merch>) {

        this.merch.run {
            clear()
            addAll(banners)
        }

        notifyDataSetChanged()
    }

    // Gets the number of animals in the list
    override fun getItemCount() = merch.size

    // Inflates the item view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_merch, parent, false)

    )

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(merch[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private fun View.requestNewSize(
            width: Int
        ) {
            layoutParams.width = width
            layoutParams = layoutParams
        }

        init {
            itemView.requestNewSize(itemWidth)
        }

        fun bindData(type: Merch) {
            itemView.merchTitle.text = type.name
            itemView.merchPrice.text = type.price
            itemView.buttonBuy.tag = type.click
            // itemView.descriptionView.text = type.description

            Picasso
                .get()
                .load(type.image)
                .placeholder(R.drawable.teamsesh)
                .into(itemView.merchImage)

        }
    }
}
