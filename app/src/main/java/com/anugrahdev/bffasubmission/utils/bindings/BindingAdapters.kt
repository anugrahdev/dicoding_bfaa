package com.anugrahdev.bffasubmission.utils.bindings

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import com.anugrahdev.bffasubmission.R

@BindingAdapter("setImageUrl")
fun AppCompatImageView.setImageUrl(imageUrl: String?) {
    load(imageUrl) {
        transformations(CircleCropTransformation())
        crossfade(true)
        placeholder(R.drawable.placeholder_user)
        error(R.drawable.placeholder_user)
    }
}