package com.example.hiltexample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltexample.data.model.Post
import com.example.hiltexample.databinding.ItemPostBinding

class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.tvTitle.text = post.title
        binding.tvDescription.text = post.body
    }

    companion object {
        fun from(parent: ViewGroup): PostViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemPostBinding.inflate(layoutInflater, parent, false)
            return PostViewHolder(binding)
        }
    }
}