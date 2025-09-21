package com.example.example01_listusers.data

import com.example.example01_listusers.R

data class User(
    val image: Int,
    val name: String
) {
    companion object {
        val data get() = listOf(
            User(
                image = R.drawable.user_item_image,
                name = "Deivi De la Vega"
            ),
            User(
                image = R.drawable.user_item_image,
                name = "Deivi De la Vega1"
            ),
            User(
                image = R.drawable.user_item_image,
                name = "Deivi De la Vega2"
            ),
            User(
                image = R.drawable.user_item_image,
                name = "Deivi De la Vega3"
            ),
        )
    }
}