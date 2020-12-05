package com.example.codeaddict_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codeaddict_app.R
import com.example.codeaddict_app.data.models.api.commit.Commit
import kotlinx.android.synthetic.main.item_commit.view.*

class CommitsAdapter(private var commits: List<Commit>) :
    RecyclerView.Adapter<CommitsAdapter.RepositoryViewHolder>() {
    inner class RepositoryViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_commit, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return commits.size
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val commit = commits[position]
        with(holder.itemView) {
            tv_author_name.text = commit.author.name
            tv_author_email.text = commit.author.email
            tv_commit_message.text = commit.message
            tv_number.text = (position + 1).toString()
        }
    }

    fun clearItems() {
        commits = emptyList()
    }

    fun addItems(list: List<Commit>) {
        commits = list
    }
}