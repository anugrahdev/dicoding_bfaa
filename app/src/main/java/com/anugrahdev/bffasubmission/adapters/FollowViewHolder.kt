package com.anugrahdev.bffasubmission.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anugrahdev.bffasubmission.databinding.ItemFollowItemBinding
import com.anugrahdev.bffasubmission.databinding.ItemUsersBinding
import com.anugrahdev.bffasubmission.models.followthing.FollowItems

class FollowViewHolder(val binding: ItemFollowItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(model: FollowItems) {
        binding.user = model
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): FollowViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding: ItemFollowItemBinding = ItemFollowItemBinding.inflate(inflater, parent, false)
            return FollowViewHolder(binding)
        }
    }
}