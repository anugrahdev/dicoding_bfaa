package com.anugrahdev.bffasubmission.views

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.anugrahdev.bffasubmission.R
import com.anugrahdev.bffasubmission.adapters.UserAdapter
import com.anugrahdev.bffasubmission.databinding.ActivityHomeBinding
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var userAdapter: UserAdapter
    private val viewModel: GithubViewModel by viewModels()

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.lifecycleOwner = this

        userAdapter = UserAdapter { user ->
            Intent(this, DetailActivity::class.java).also {
                it.putExtra(EXTRA_USER, user)
                startActivity(it)
            }
        }
        setSupportActionBar(toolbar)

        binding.rvHomeUsers.adapter = userAdapter


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_sv, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = "Masukkan username"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@HomeActivity, query, Toast.LENGTH_SHORT).show()
                CoroutineScope(Dispatchers.IO).launch {
                    delay(1000L)
                    viewModel.getSearchUsers(query, {
                        viewModel.listUsers.observe(this@HomeActivity, Observer {
                            userAdapter.submitList(it)
                            if (it.isNotEmpty()) {
                                llHomeSearchNoResult.visibility = View.GONE
                            }
                        })
                    }, {
                        Toast.makeText(this@HomeActivity, getString(R.string.error_occurred), Toast.LENGTH_SHORT)
                            .show()

                    })
                }
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                CoroutineScope(Dispatchers.IO).launch {
                    delay(1500L)
                    viewModel.getSearchUsers(newText, {
                        viewModel.listUsers.observe(this@HomeActivity, Observer {
                            userAdapter.submitList(it)
                            if (it.isNotEmpty()) {
                                llHomeSearchNoResult.visibility = View.GONE
                            }
                        })
                    }, {

                    })
                }
                return false
            }
        })
        return true
    }

}