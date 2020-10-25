package com.anugrahdev.bffasubmission.networks.repositories

import com.anugrahdev.bffasubmission.models.followthing.FollowItems
import com.anugrahdev.bffasubmission.models.profile.Users
import com.anugrahdev.bffasubmission.models.search.ItemsUser
import com.anugrahdev.bffasubmission.networks.SafeApiRequest
import com.anugrahdev.bffasubmission.networks.ServiceFactory
import com.anugrahdev.bffasubmission.networks.restapi.RestApiGithub
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GithubRepository (private val scope: CoroutineScope) : SafeApiRequest() {
    private val restApi = ServiceFactory.getApiService(RestApiGithub::class.java)

    fun getSearchUsers(
        query:String,
        onSuccess: (List<ItemsUser>?) -> Unit,
        onError: (Exception) -> Unit,
    ) {
        scope.launch {
            delay(1500L)
            try {
                val result = apiRequest { restApi.getSearchUsers(query) }
                onSuccess(result?.items)
            } catch (e: Exception) {
                onError(e)
            }
        }
    }

    fun getUser(
        username:String,
        onSuccess: (Users?) -> Unit,
        onError: (Exception) -> Unit,
    ) {
        scope.launch {
            try {
                val result = apiRequest { restApi.getUser(username) }
                onSuccess(result)
            } catch (e: Exception) {
                onError(e)
            }
        }
    }

    fun getFollowers(
        username:String,
        onSuccess: (List<FollowItems>?) -> Unit,
        onError: (Exception) -> Unit,
    ) {
        scope.launch {
            try {
                val result = apiRequest { restApi.getUserFollowers(username) }
                onSuccess(result)
            } catch (e: Exception) {
                onError(e)
            }
        }
    }

    fun getFollowing(
        username:String,
        onSuccess: (List<FollowItems>?) -> Unit,
        onError: (Exception) -> Unit,
    ) {
        scope.launch {
            try {
                val result = apiRequest { restApi.getUserFollowing(username) }
                onSuccess(result)
            } catch (e: Exception) {
                onError(e)
            }
        }
    }

}