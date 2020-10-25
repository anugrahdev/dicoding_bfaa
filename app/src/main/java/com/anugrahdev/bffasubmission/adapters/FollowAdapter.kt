package com.anugrahdev.bffasubmission.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.anugrahdev.bffasubmission.models.followthing.FollowItems
import com.anugrahdev.bffasubmission.utils.AdapterCallback

class FollowAdapter(val onItemClick:(FollowItems) -> Unit): ListAdapter<FollowItems, FollowViewHolder>(
    AdapterCallback.diffFollowItemsCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowViewHolder {
        return FollowViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: FollowViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
        holder.itemView.setOnClickListener {
            onItemClick(model)
        }
    }

}