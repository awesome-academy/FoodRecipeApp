package com.example.foodrecipeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipeapp.data.model.IntroSlide
import com.example.foodrecipeapp.databinding.ItemIntroSlideBinding

class IntroSlideAdapter(
    private val introSlides: List<IntroSlide>
) : RecyclerView.Adapter<IntroSlideAdapter.IntroSlideViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewHolder {
        val binding =
            ItemIntroSlideBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IntroSlideViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return introSlides.size
    }

    override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
        holder.bindData(introSlides[position])
    }

    inner class IntroSlideViewHolder(private val binding: ItemIntroSlideBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(introSlide: IntroSlide) {
            binding.tvSlogan1.text = introSlide.slogan
            binding.tvSloganContent.text = introSlide.content
            binding.imgBackground.setImageResource(introSlide.backgroundImg)
        }
    }
}
