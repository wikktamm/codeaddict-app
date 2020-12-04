package com.example.codeaddict_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.codeaddict_app.R
import com.example.codeaddict_app.data.Repository

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {
    inner class RepositoryViewHolder(view: View) : RecyclerView.ViewHolder(view)

    private val differCallback = object : DiffUtil.ItemCallback<Repository>() {
        override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
            TODO("Not yet implemented")
        }

        override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
            TODO("Not yet implemented")
        }
    }
    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}