package com.github.myapplication

import com.github.myapplication.Adpaters.RepoAdapter
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.myapplication.Models.GitHubUser
import kotlinx.coroutines.launch

class Detailprofile : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var RepoAdapter: RepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailprofile)
        val user = intent.getParcelableExtra<GitHubUser>("USER")

        findViewById<TextView>(R.id.user_name).text = user?.login
        Glide.with(this).load(user?.avatar_url).circleCrop().into(findViewById(R.id.user_avatar))

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        fetchGitHubrepo(user!!.login)
        fetchGitHubprofile(user.login)
    }

    private fun fetchGitHubrepo(username: String) {
        lifecycleScope.launch {
            val users = RetrofitInstance.api.getUserRepos(username)
            RepoAdapter = RepoAdapter(users) { user ->

            }
            recyclerView.adapter =RepoAdapter
        }
    }
    private fun fetchGitHubprofile(username: String) {
        lifecycleScope.launch {
            val users = RetrofitInstance.api.getUserprofile(username)
            findViewById<TextView>(R.id.followers).text = users?.followers.toString()
            findViewById<TextView>(R.id.following).text = users.following.toString()
            findViewById<TextView>(R.id.repos).text = users?.public_repos.toString()
            findViewById<TextView>(R.id.country).text = users?.location.toString()
            findViewById<TextView>(R.id.aboutme).text = users?.bio.toString()+"\n Email:"+users?.email.toString()+"\n Company:"+users?.company.toString()+"\n Created:"+users?.created_at.toString()
        }
    }
}