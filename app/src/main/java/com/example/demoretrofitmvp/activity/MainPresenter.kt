package com.example.demoretrofitmvp.activity

import com.example.demoretrofitmvp.api.RetrofitClient
import com.example.demoretrofitmvp.model.MainView
import com.example.demoretrofitmvp.model.data.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private val view: MainView) {

    fun loadUsersListData() {
        RetrofitClient().apiService.getUsersList().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    val users = response.body()
                    if (users != null && users.isNotEmpty()) {
                        view.showUsersListData(users)
                    }
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

}
