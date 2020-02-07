package com.tds.githubtrending.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tds.githubtrending.BR
import com.tds.githubtrending.databinding.ItemRepoListBinding
import com.tds.githubtrending.model.Item
import com.tds.githubtrending.ui.repolist.RepoListViewModel
import kotlinx.android.synthetic.main.item_repo_list.view.*

class RepoListViewHolder constructor(
    private val dataBinding : ItemRepoListBinding,
    private val repoListViewModel: RepoListViewModel
): RecyclerView.ViewHolder(dataBinding.root){
    val avatarImage = itemView.itemAvatar
    fun setup(itemData: Item){
        dataBinding.setVariable(BR.itemData,itemData)
        dataBinding.executePendingBindings()

        Picasso.get().load(itemData.owner.avatar_url).into(avatarImage)



    }
}