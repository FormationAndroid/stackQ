package com.example.stackapp.models


import com.google.gson.annotations.SerializedName

data class LastQuestions(
    @SerializedName("has_more") val hasMore: Boolean,
    val items: List<Item>,
    @SerializedName("quota_max") val quotaMax: Int,
    @SerializedName("quota_remaining") val quotaRemaining: Int
)