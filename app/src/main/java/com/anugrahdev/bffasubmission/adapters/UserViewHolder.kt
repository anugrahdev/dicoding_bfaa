package com.anugrahdev.bffasubmission.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anugrahdev.bffasubmission.databinding.ItemUsersBinding
import com.anugrahdev.bffasubmission.models.search.ItemsUser

class UserViewHolder(private val binding: ItemUsersBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(model: ItemsUser) {
        binding.user = model
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): UserViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding: ItemUsersBinding = ItemUsersBinding.inflate(inflater, parent, false)
            return UserViewHolder(binding)
        }
    }
}