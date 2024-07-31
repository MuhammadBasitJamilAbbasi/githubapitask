package com.github.myapplication.Adpaters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.myapplication.Models.GitHubUser
import com.github.myapplication.R

class UserAdapter(private val users: List<GitHubUser>, private val onItemClick: (GitHubUser) -> Unit) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userName: TextView = view.findViewById(R.id.user_name)
        val userAvatar: ImageView = view.findViewById(R.id.user_avatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.userview, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.userName.text = user.login
        Glide.with(holder.userAvatar.context).load(user.avatar_url).circleCrop().into(holder.userAvatar)

        holder.itemView.setOnClickListener {
            onItemClick(user)
        }
    }

    override fun getItemCount() = users.size
}
