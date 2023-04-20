package com.example.demoretrofitmvp.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.demoretrofitmvp.R
import com.example.demoretrofitmvp.adapter.UserAdapter
import com.example.demoretrofitmvp.databinding.ActivityMainBinding
import com.example.demoretrofitmvp.model.MainView
import com.example.demoretrofitmvp.model.data.User
import com.google.gson.Gson

class MainActivity : AppCompatActivity(), MainView, UserAdapter.MyClickListener {


    private lateinit var presenter: MainPresenter
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        presenter = MainPresenter(this)
        presenter.loadUsersListData()

    }


    override fun showUsersListData(users: List<User>) {
        val adapter = UserAdapter(users, this)
        mBinding.recyclerView.adapter = adapter
        Log.d("Ashu",Gson().toJson(users))
    }

    override fun onItemClick(item: User) {
        val intent = Intent(this, PostActivity::class.java)
        intent.putExtra("id", item.id)
        startActivity(intent)
    }

}