package com.anugrahdev.bffasubmission.utils

import androidx.recyclerview.widget.DiffUtil
import com.anugrahdev.bffasubmission.models.followthing.FollowItems
import com.anugrahdev.bffasubmission.models.search.ItemsUser

object AdapterCallback {

    val diffUsersCallback = object : DiffUtil.ItemCallback<ItemsUser>() {

        override fun areItemsTheSame(oldItem: ItemsUser, newItem: ItemsUser): Boolean {
            return oldItem.login == newItem.login
        }

        override fun areContentsTheSame(oldItem: ItemsUser, newItem: ItemsUser): Boolean {
            return oldItem == newItem
        }

    }

    val diffFollowItemsCallback = object : DiffUtil.ItemCallback<FollowItems>() {

        override fun areItemsTheSame(oldItem: FollowItems, newItem: FollowItems): Boolean {
            return oldItem.login == newItem.login
        }

        override fun areContentsTheSame(oldItem: FollowItems, newItem: FollowItems): Boolean {
            return oldItem == newItem
        }

    }

}