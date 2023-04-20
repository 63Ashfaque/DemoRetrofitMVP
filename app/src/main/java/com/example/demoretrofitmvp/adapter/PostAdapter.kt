package com.example.demoretrofitmvp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoretrofitmvp.databinding.ItemPostCardViewBinding
import com.example.demoretrofitmvp.databinding.ItemUserCardViewBinding
import com.example.demoretrofitmvp.model.data.PostItem
import com.example.demoretrofitmvp.model.data.User

class PostAdapter(private var items: List<PostItem>, private val clickListener: MyClickListener) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val mBinding = ItemPostCardViewBinding.inflate(inflater, parent, false)
        return ViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, clickListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(private val itemBinding: ItemPostCardViewBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: PostItem, clickListener1: MyClickListener) {
            itemBinding.itemVariable = item
            itemBinding.clickListener = clickListener1
            itemBinding.executePendingBindings()
        }
    }

    interface MyClickListener {
        fun onItemClick(item: PostItem)
    }
}