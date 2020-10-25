package com.anugrahdev.bffasubmission.networks.restapi

import com.anugrahdev.bffasubmission.models.followthing.FollowItems
import com.anugrahdev.bffasubmission.models.search.ItemsUser
import com.anugrahdev.bffasubmission.models.search.Search
import com.anugrahdev.bffasubmission.models.profile.Users
import retrofit2.Response
import retrofit2.http.*

interface RestApiGithub {

    @GET("search/users")
    suspend fun getSearchUsers(
        @Query("q") keyword: String
    ): Response<Search<ItemsUser>>

    @GET("users/{username}")
    suspend fun getUser(
        @Path("username") username: String
    ): Response<Users>

    @GET("users/{username}/followers")
    suspend fun getUserFollowers(
        @Path("username") username: String
    ): Response<List<FollowItems>>

    @GET("users/{username}/following")
    suspend fun getUserFollowing(
        @Path("username") username: String
    ): Response<List<FollowItems>>


}