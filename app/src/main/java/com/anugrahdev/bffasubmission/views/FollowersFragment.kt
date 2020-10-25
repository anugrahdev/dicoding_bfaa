package com.anugrahdev.bffasubmission.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anugrahdev.bffasubmission.adapters.FollowAdapter
import com.anugrahdev.bffasubmission.databinding.FragmentFollowersBinding
import com.anugrahdev.bffasubmission.models.search.ItemsUser
import kotlinx.android.synthetic.main.fragment_followers.*

class FollowersFragment : Fragment() {

    private lateinit var followAdapter: FollowAdapter
    private lateinit var binding:FragmentFollowersBinding
    lateinit var viewModel: GithubViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowersBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(GithubViewModel::class.java)
        binding.vm = viewModel
        followAdapter = FollowAdapter {}
        val data = activity?.intent?.extras?.getParcelable<ItemsUser>(DetailActivity.EXTRA_USER)

        viewModel.getFollowers(data!!.login, {
            viewModel.listFollowers.observe(viewLifecycleOwner, Observer {
                followAdapter.submitList(it)
            })
        }, {

        })

        rvFollowers.adapter = followAdapter

    }

}