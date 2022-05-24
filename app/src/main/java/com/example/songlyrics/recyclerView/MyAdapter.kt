package com.example.songlyrics.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.songlyrics.databinding.ItemViewBinding
import com.example.songlyrics.fragments.HomeSearchDirections
import com.example.songlyrics.model.Hits

class MyAdapter(private val fragment: Fragment) : ListAdapter<Hits,MyAdapter.MyViewHolder>(LyricsDiffUtil()) {

    lateinit var binding: ItemViewBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        holder.setData(data)
    }

    inner class MyViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(hits: Hits) {
            binding.hits = hits
            binding.root.setOnClickListener {
                findNavController(fragment = fragment).navigate(HomeSearchDirections.actionHomeSearchToDisplayLyrics(hits.result.url))

            }
        }
    }
}

class LyricsDiffUtil(): DiffUtil.ItemCallback<Hits>(){
    override fun areItemsTheSame(oldItem: Hits, newItem: Hits): Boolean {
        return oldItem.result.id == newItem.result.id
    }

    override fun areContentsTheSame(oldItem: Hits, newItem: Hits): Boolean {
        return oldItem == newItem
    }

}