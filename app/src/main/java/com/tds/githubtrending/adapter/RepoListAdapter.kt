package com.tds.githubtrending.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tds.githubtrending.adapter.viewholder.RepoListViewHolder
import com.tds.githubtrending.databinding.FragmentRepoListBinding
import com.tds.githubtrending.databinding.ItemRepoListBinding
import com.tds.githubtrending.model.Item
import com.tds.githubtrending.ui.repolist.RepoListViewModel

class RepoListAdapter (private val repoListViewModel: RepoListViewModel): RecyclerView.Adapter<RepoListViewHolder>(){

    var repoList: List<Item> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListViewHolder {
       val dataBinding = ItemRepoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepoListViewHolder(dataBinding, repoListViewModel )
    }

    override fun getItemCount(): Int = repoList.size

    override fun onBindViewHolder(holder: RepoListViewHolder, position: Int) {
        holder.setup(repoList[position])
    }

    fun updateRepoList(repoList: List<Item>){
        this.repoList = repoList
        notifyDataSetChanged()
    }
}