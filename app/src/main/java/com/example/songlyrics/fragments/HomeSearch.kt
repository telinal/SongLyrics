package com.example.songlyrics.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.songlyrics.api.RetrofitHelper
import com.example.songlyrics.databinding.FragmentHomeSearchBinding
import com.example.songlyrics.recyclerView.MyAdapter
import com.example.songlyrics.repository.Repository
import com.example.songlyrics.viewmodel.MainViewModel
import com.example.songlyrics.viewmodel.MainViewModelFactory


class HomeSearch : Fragment() {


    lateinit var homeSearchBinding: FragmentHomeSearchBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeSearchBinding = FragmentHomeSearchBinding.inflate(inflater, container, false)
        return homeSearchBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, MainViewModelFactory(Repository(RetrofitHelper.getListSong()))).get(MainViewModel::class.java)

        val adapter = MyAdapter(this)
        homeSearchBinding.recyclerviewId.adapter = adapter
        viewModel.songListShow.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        homeSearchBinding.searchBox.addTextChangedListener {
            viewModel.getSong(it.toString())

        }

        homeSearchBinding.recyclerviewId.setOnClickListener() {
        }

    }



}