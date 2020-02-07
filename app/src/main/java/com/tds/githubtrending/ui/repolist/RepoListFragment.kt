package com.tds.githubtrending.ui.repolist


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.tds.githubtrending.adapter.RepoListAdapter
import com.tds.githubtrending.databinding.FragmentRepoListBinding
import kotlinx.android.synthetic.main.fragment_repo_list.*

/**
 * A simple [Fragment] subclass.
 */
class RepoListFragment : Fragment() {

    private lateinit var viewDataBinding : FragmentRepoListBinding
    private lateinit var adapter: RepoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewDataBinding = FragmentRepoListBinding.inflate(inflater, container, false)
        viewDataBinding.apply {
            viewmodel = ViewModelProviders.of(this@RepoListFragment).get(RepoListViewModel::class.java)
            setLifecycleOwner (viewLifecycleOwner)      //to hold data from onstart to on destroyed state

        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewmodel?.fetchRepoList()
        setupAdapter()
        setupObservers()
    }

    private fun setupObservers(){
        viewDataBinding.viewmodel?.repoList?.observe(
            viewLifecycleOwner,
            Observer {
                adapter.updateRepoList(it)
            }
        )
        viewDataBinding.viewmodel?.message?.observe(
            viewLifecycleOwner,
            Observer {

            }
        )
    }

    private fun setupAdapter(){
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null){
            adapter = RepoListAdapter(viewModel)
            recyclerRepoList.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = adapter
            }

        }
    }

}
