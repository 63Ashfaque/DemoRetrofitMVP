package com.example.demoretrofitmvp.model

import com.example.demoretrofitmvp.model.data.User
import com.example.demoretrofitmvp.model.data.PostItem

interface PostView {
    fun showData(user: User)
    fun showPostList(post: List<PostItem>)
}