package com.example.foodrecipeapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipeapp.data.model.HomeChild
import com.example.foodrecipeapp.databinding.LayoutPopularCategoryHomeChildBinding
import com.example.foodrecipeapp.databinding.LayoutRecentRecipeHomeChildBinding
import com.example.foodrecipeapp.databinding.LayoutSearchHomeChildBinding
import com.example.foodrecipeapp.utils.base.BaseViewHolder

class HomeChildAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listHomeChild: MutableList<HomeChild> = mutableListOf()

    override fun getItemViewType(position: Int): Int {
        val homeChild = listHomeChild[position]
        return homeChild.typeView
    }

    @SuppressLint("ReturnCount")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HOME_SEARCH_VIEW -> {
                HomeSearchRecipeViewHolder(
                    LayoutSearchHomeChildBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            HOME_POPULAR_CATEGORY_VIEW -> {
                HomePopularCategoryViewHolder(
                    LayoutPopularCategoryHomeChildBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> {
                HomeRecentRecipeViewHolder(
                    LayoutRecentRecipeHomeChildBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return listHomeChild.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? BaseViewHolder<HomeChild>)?.bindData(listHomeChild[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listHomeChild: MutableList<HomeChild>) {
        this.listHomeChild = listHomeChild
        notifyDataSetChanged()
    }

    inner class HomeSearchRecipeViewHolder(private val binding: LayoutSearchHomeChildBinding) :
        BaseViewHolder<HomeChild>(binding) {
        override fun bindData(itemBinding: HomeChild) {
            // TODO("Not yet implemented")
        }
    }

    inner class HomePopularCategoryViewHolder(private val binding: LayoutPopularCategoryHomeChildBinding) :
        BaseViewHolder<HomeChild>(binding) {
        override fun bindData(itemBinding: HomeChild) {
            // TODO("Not yet implemented")
        }
    }

    inner class HomeRecentRecipeViewHolder(private val binding: LayoutRecentRecipeHomeChildBinding) :
        BaseViewHolder<HomeChild>(binding) {
        override fun bindData(itemBinding: HomeChild) {
            // TODO("Not yet implemented")
        }
    }

    companion object {
        const val HOME_SEARCH_VIEW = 1
        const val HOME_POPULAR_CATEGORY_VIEW = 2
        const val HOME_RECENT_RECIPE_VIEW = 3
    }
}
