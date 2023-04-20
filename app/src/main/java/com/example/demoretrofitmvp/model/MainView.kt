package com.example.demoretrofitmvp.model

import com.example.demoretrofitmvp.model.data.User

interface MainView {
    fun showUsersListData(users: List<User>)
}