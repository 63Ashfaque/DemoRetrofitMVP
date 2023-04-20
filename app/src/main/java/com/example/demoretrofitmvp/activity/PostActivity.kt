package com.example.demoretrofitmvp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.demoretrofitmvp.R
import com.example.demoretrofitmvp.adapter.PostAdapter
import com.example.demoretrofitmvp.adapter.UserAdapter
import com.example.demoretrofitmvp.databinding.ActivityPostBinding
import com.example.demoretrofitmvp.model.PostView
import com.example.demoretrofitmvp.model.data.PostItem
import com.example.demoretrofitmvp.model.data.User
import com.google.gson.Gson

class PostActivity : AppCompatActivity(), PostView ,PostAdapter.MyClickListener{

    private lateinit var presenter: PostPresenter
    private lateinit var mBinding: ActivityPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_post)
        presenter = PostPresenter(this)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            val id = bundle.getInt("id")
            presenter.loadData(id)
            presenter.loadPostData(id)
        }
    }

    override fun showData(user: User) {
        Log.d("Ashu", Gson().toJson(user))
        mBinding.tvName.text = user.name
        mBinding.tvUserName.text = user.username
        mBinding.tvPhone.text = user.phone
        mBinding.tvCity.text = user.address.city
    }

    override fun showPostList(post: List<PostItem>) {
        val adapter = PostAdapter(post, this)
        mBinding.recyclerView.adapter = adapter

    }

    override fun onItemClick(item: PostItem) {
    }


}