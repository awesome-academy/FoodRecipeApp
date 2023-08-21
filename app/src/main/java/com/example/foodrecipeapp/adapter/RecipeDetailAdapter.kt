package com.example.foodrecipeapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipeapp.constant.Constant
import com.example.foodrecipeapp.data.model.ExtendedIngredient
import com.example.foodrecipeapp.databinding.ItemIngredientBinding
import com.example.foodrecipeapp.utils.ext.loadImageWithUrl

class RecipeDetailAdapter : RecyclerView.Adapter<RecipeDetailAdapter.RecipeDetailViewHolder>() {

    private var listExtendedIngredient: MutableList<ExtendedIngredient> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeDetailViewHolder {
        val binding =
            ItemIngredientBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeDetailViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listExtendedIngredient.size
    }

    override fun onBindViewHolder(holder: RecipeDetailViewHolder, position: Int) {
        holder.bindData(listExtendedIngredient[position])
    }

    fun setIngredientsData(listExtendedIngredient: MutableList<ExtendedIngredient>) {
        this.listExtendedIngredient = listExtendedIngredient
    }

    inner class RecipeDetailViewHolder(private val binding: ItemIngredientBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bindData(extendedIngredient: ExtendedIngredient) {
            binding.imgFood.loadImageWithUrl("${Constant.BASE_URL_IMAGE_INGREDIENT}${extendedIngredient.image}")
            binding.tvIngredientName.text = extendedIngredient.name
            binding.tvIngredientQuantity.text =
                "${extendedIngredient.amount.toInt()} ${extendedIngredient.nameClean}"
        }
    }
}
