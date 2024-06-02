package com.sb.artgallery.entity

import androidx.annotation.DrawableRes

data class Art(
    @DrawableRes val image: Int, val title: String, val description: String?
)