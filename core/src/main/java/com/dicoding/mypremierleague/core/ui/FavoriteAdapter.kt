package com.dicoding.mypremierleague.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.mypremierleague.core.R
import com.dicoding.mypremierleague.core.databinding.ItemListFavoriteTeamBinding
import com.dicoding.mypremierleague.core.domain.model.Team

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.ListViewHolder>() {

    private var listData = ArrayList<Team>()
    var onItemClick: ((Team) -> Unit)? = null

    fun setData(newListData: List<Team>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int) =
        ListViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list_favorite_team, viewGroup, false))

    override fun onBindViewHolder(holder: FavoriteAdapter.ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount() = listData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListFavoriteTeamBinding.bind(itemView)
        fun bind(data: Team) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.teamBadge)
                    .into(ivFavoriteImage)

                tvFavoriteTeam.text = data.team
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke((listData[bindingAdapterPosition]))
            }
        }
    }
}