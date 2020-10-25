package com.anugrahdev.bffasubmission.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anugrahdev.bffasubmission.adapters.FollowAdapter
import com.anugrahdev.bffasubmission.databinding.FragmentFollowersBinding
import com.anugrahdev.bffasubmission.databinding.FragmentFollowingBinding
import com.anugrahdev.bffasubmission.models.search.ItemsUser
import kotlinx.android.synthetic.main.fragment_following.*

class FollowingFragment : Fragment() {

    private lateinit var followAdapter: FollowAdapter
    lateinit var viewModel: GithubViewModel
    private lateinit var binding:FragmentFollowingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowingBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = this
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(GithubViewModel::class.java)
        binding.vm = viewModel
        followAdapter = FollowAdapter {}
        val data = activity?.intent?.extras?.getParcelable<ItemsUser>(DetailActivity.EXTRA_USER)

        viewModel.getFollowing(data!!.login, {
            viewModel.listFollowing.observe(viewLifecycleOwner, Observer {
                followAdapter.submitList(it)
            })
        }, {

        })

        rvFollowing.adapter = followAdapter



    }

}