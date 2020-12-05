package com.example.codeaddict_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codeaddict_app.R
import com.example.codeaddict_app.data.models.commit.Commit

class CommitsAdapter(private val commits: List<Commit>) :
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
        val repo = commits[position]
        with(holder.itemView) {

        }
    }
}