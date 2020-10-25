package com.anugrahdev.bffasubmission.models.search

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Search<T>(
    @SerializedName("items")
    val items: List<T>,
    @SerializedName("incomplete_results")
    val incomplete_results: Boolean,
    @SerializedName("total_count")
    val total_count: Int
)