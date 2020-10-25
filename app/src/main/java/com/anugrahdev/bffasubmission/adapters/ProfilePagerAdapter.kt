package com.anugrahdev.bffasubmission.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.anugrahdev.bffasubmission.views.FollowersFragment
import com.anugrahdev.bffasubmission.views.FollowingFragment

class ProfilePagerAdapter(private val mContext: Lifecycle, fm: FragmentManager) : FragmentStateAdapter(fm, mContext) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return FollowersFragment()
            1 -> return FollowingFragment()
        }
        return FollowersFragment()
    }
}