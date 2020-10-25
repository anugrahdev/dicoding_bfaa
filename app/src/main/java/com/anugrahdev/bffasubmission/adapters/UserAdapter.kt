package com.anugrahdev.bffasubmission.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.anugrahdev.bffasubmission.utils.AdapterCallback
import com.anugrahdev.bffasubmission.models.search.ItemsUser

class UserAdapter(val onItemClick:(ItemsUser) -> Unit): ListAdapter<ItemsUser, UserViewHolder>(
    AdapterCallback.diffUsersCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
        holder.itemView.setOnClickListener {
            onItemClick(model)
        }
    }

}