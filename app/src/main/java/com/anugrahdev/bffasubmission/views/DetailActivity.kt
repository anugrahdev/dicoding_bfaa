package com.anugrahdev.bffasubmission.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.anugrahdev.bffasubmission.R
import com.anugrahdev.bffasubmission.adapters.ProfilePagerAdapter
import com.anugrahdev.bffasubmission.databinding.ActivityDetailBinding
import com.anugrahdev.bffasubmission.models.search.ItemsUser
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_USER = "extra_user"
    }
    private val viewModel: GithubViewModel by viewModels()
    private lateinit var binding:ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.lifecycleOwner = this
        binding.toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        binding.toolbar.setNavigationOnClickListener { this.onBackPressed() }
        val userData: ItemsUser = intent.extras?.getParcelable(EXTRA_USER)!!
        setupEventsPager()

        viewModel.getUser(username = userData.login, {
            binding.user = viewModel.user
        }, {
            Toast.makeText(this, getString(R.string.error_occurred), Toast.LENGTH_SHORT).show()
        })
    }

    private fun setupEventsPager() {
        view_pager.adapter = ProfilePagerAdapter(lifecycle, supportFragmentManager)
        view_pager.offscreenPageLimit = 2
        TabLayoutMediator(tab_layout, view_pager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = getString(R.string.followers)
                    }
                    1 -> {
                        tab.text = getString(R.string.following)
                    }
                }
            }).attach()

    }
}