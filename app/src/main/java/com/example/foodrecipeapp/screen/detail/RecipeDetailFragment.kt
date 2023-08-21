package com.example.foodrecipeapp.screen.detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.example.foodrecipeapp.adapter.RecipeDetailAdapter
import com.example.foodrecipeapp.data.model.RecipeDetail
import com.example.foodrecipeapp.data.repo.RecipeRepo
import com.example.foodrecipeapp.data.repo.source.remote.RecipeRemoteDataSource
import com.example.foodrecipeapp.databinding.FragmentRecipeDetailBinding
import com.example.foodrecipeapp.utils.base.BaseViewBindingFragment
import com.example.foodrecipeapp.utils.ext.goBackFragment
import com.example.foodrecipeapp.utils.ext.loadImageWithUrl
import java.lang.Exception

class RecipeDetailFragment(
    private val recipeId: Int
) : BaseViewBindingFragment<FragmentRecipeDetailBinding>(), RecipeDetailContract.View {

    private lateinit var recipeDetailPresenter: RecipeDetailPresenter
    private val recipeDetailAdapter: RecipeDetailAdapter by lazy {
        RecipeDetailAdapter()
    }

    override fun createBindingFragment(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRecipeDetailBinding {
        return FragmentRecipeDetailBinding.inflate(inflater, container, false)
    }

    override fun initData() {
        recipeDetailPresenter = RecipeDetailPresenter(
            RecipeRepo.getInstanceRecipeRemoteRepo(RecipeRemoteDataSource.getInstance())
        )
        recipeDetailPresenter.setView(this)
        recipeDetailPresenter.getRecipeDetail(recipeId)
    }

    override fun initView() {
        binding.imgBackButton.setOnClickListener {
            goBackFragment()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onGetRecipeDetail(recipeDetail: RecipeDetail) {
        val extendedIngredientItems = recipeDetail.extendedIngredients.size
        binding.tvTitle.text = recipeDetail.title

        if (recipeDetail.servings <= 1) {
            binding.tvServing.text = "${recipeDetail.servings} Serving"
        } else {
            binding.tvServing.text = "${recipeDetail.servings} Servings"
        }

        if (recipeDetail.aggregateLikes <= 1) {
            binding.tvTotalLike.text = "${recipeDetail.aggregateLikes} Like"
        } else {
            binding.tvTotalLike.text = "${recipeDetail.aggregateLikes} Likes"
        }

        if (recipeDetail.readyInMinutes <= 1) {
            binding.tvEstimateTime.text = "${recipeDetail.readyInMinutes} Min"
        } else {
            binding.tvEstimateTime.text = "${recipeDetail.readyInMinutes} Mins"
        }

        if (extendedIngredientItems <= 1) {
            binding.tvItems.text = "$extendedIngredientItems Item"
        } else {
            binding.tvItems.text = "$extendedIngredientItems Items"
        }

        binding.imgFood.loadImageWithUrl(recipeDetail.image)

        recipeDetailAdapter.setIngredientsData(recipeDetail.extendedIngredients)
        binding.rcvRecipeDetailInfo.adapter = recipeDetailAdapter
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(context, exception?.message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        @JvmStatic
        fun newInstance(recipeId: Int) = RecipeDetailFragment(recipeId)
    }
}
