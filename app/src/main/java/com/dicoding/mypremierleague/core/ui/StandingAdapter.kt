package com.dicoding.mypremierleague.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.mypremierleague.R
import com.dicoding.mypremierleague.core.domain.model.Standing
import com.dicoding.mypremierleague.databinding.ItemListStandingsBinding

class StandingAdapter : RecyclerView.Adapter<StandingAdapter.ListViewHolder>() {

    private var listData = ArrayList<Standing>()
    var onItemClick: ((Standing) -> Unit)? = null

    fun setData(newListData: List<Standing>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list_standings, viewGroup, false))

    override fun onBindViewHolder(holder: StandingAdapter.ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount() = listData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListStandingsBinding.bind(itemView)
        fun bind(data: Standing) {
            with(binding) {
                tvStandingPosition.text = data.rank
                Glide.with(itemView.context)
                    .load(data.badgeTeam)
                    .into(ivStandingBadgeTeam)
                tvStandingNameTeam.text = data.team
                tvStandingPlayed.text = data.played
                tvStandingGoalsDifference.text = data.goalDifference
                tvStandingPoints.text = data.points
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke((listData[bindingAdapterPosition]))
            }
        }
    }
}