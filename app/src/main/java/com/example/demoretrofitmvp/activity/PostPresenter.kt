package com.example.demoretrofitmvp.activity

import com.example.demoretrofitmvp.api.RetrofitClient
import com.example.demoretrofitmvp.model.PostView
import com.example.demoretrofitmvp.model.data.PostItem
import com.example.demoretrofitmvp.model.data.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostPresenter(private val view: PostView) {

    fun loadData(id: Int) {
        RetrofitClient().apiService.getUser(id).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val user = response.body()
                    if (user != null) {
                        view.showData(user)
                    }
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    fun loadPostData(id: Int) {
        RetrofitClient().apiService.getUserPostData(id).enqueue(object : Callback<List<PostItem>> {
            override fun onResponse(
                call: Call<List<PostItem>>,
                response: Response<List<PostItem>>
            ) {
                if (response.isSuccessful) {
                    val posts = response.body()
                    if (posts != null && posts.isNotEmpty()) {
                        view.showPostList(posts)
                    }
                }
            }

            override fun onFailure(call: Call<List<PostItem>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

}
