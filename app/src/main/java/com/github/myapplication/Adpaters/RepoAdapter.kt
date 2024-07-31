package com.github.myapplication.Adpaters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.myapplication.Models.GitHubRepo
import com.github.myapplication.R


class RepoAdapter(private val repos: List<GitHubRepo>, private val onItemClick: (GitHubRepo) -> Unit) : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val repoName: TextView = view.findViewById(R.id.repo_name)
        val repoDescription: TextView = view.findViewById(R.id.repo_description)
        val repoLan: TextView = view.findViewById(R.id.repo_language)
        val repoWat: TextView = view.findViewById(R.id.repo_views)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repolist, parent, false)
        return RepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = repos[position]
        holder.repoName.text = repo.name
        holder.repoDescription.text = repo.description ?: "No description"
        holder.repoLan.text=repo.language
        holder.repoWat.text=repo.stargazers_count.toString()


        holder.itemView.setOnClickListener {
            onItemClick(repo)
        }
    }

    override fun getItemCount() = repos.size
}
