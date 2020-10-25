package com.anugrahdev.bffasubmission1.utils

import android.content.Context

fun getDataJson(context: Context, fileName: String): String? {
    return context.assets.open(fileName).bufferedReader().use { it.readText() }
}