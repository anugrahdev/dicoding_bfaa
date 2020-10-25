package com.anugrahdev.bffasubmission.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anugrahdev.bffasubmission.models.followthing.FollowItems
import com.anugrahdev.bffasubmission.models.profile.Users
import com.anugrahdev.bffasubmission.models.search.ItemsUser
import com.anugrahdev.bffasubmission.networks.repositories.GithubRepository

class GithubViewModel : ViewModel() {
    private val repo = GithubRepository(viewModelScope)
    var listUsers: MutableLiveData<List<ItemsUser>> = MutableLiveData()
    var listFollowing: MutableLiveData<List<FollowItems>> = MutableLiveData()
    var listFollowers: MutableLiveData<List<FollowItems>> = MutableLiveData()
    var isLoading:MutableLiveData<Boolean> = MutableLiveData()
    lateinit var user:Users
    fun getSearchUsers(query: String, onSuccess: () -> Unit, onError: () -> Unit) {
        isLoading.postValue(true)
        repo.getSearchUsers(query,
            {
                listUsers.postValue(it)
                isLoading.postValue(false)
                onSuccess()
            }, {
                onError()
            }
        )
    }

    fun getUser(username: String, onSuccess: () -> Unit, onError: () -> Unit) {
        isLoading.postValue(true)
        repo.getUser(username,
            {
                if (it != null) {
                    user = it
                }
                isLoading.postValue(false)
                onSuccess()
            }, {
                onError()
            }
        )
    }

    fun getFollowers(username: String, onSuccess: () -> Unit, onError: () -> Unit) {
        isLoading.postValue(true)
        repo.getFollowers(username,
            {
                listFollowers.postValue(it)
                isLoading.postValue(false)
                onSuccess()
            }, {
                onError()
            }
        )
    }

    fun getFollowing(username: String, onSuccess: () -> Unit, onError: () -> Unit) {
        isLoading.postValue(true)
        repo.getFollowing(username,
            {
                listFollowing.postValue(it)
                isLoading.postValue(false)
                onSuccess()
            }, {
                onError()
            }
        )
    }
}