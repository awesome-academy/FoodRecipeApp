package com.example.foodrecipeapp.screen.onboarding

import android.os.Bundle
import com.example.foodrecipeapp.R
import com.example.foodrecipeapp.adapter.IntroSlideAdapter
import com.example.foodrecipeapp.data.model.IntroSlide
import com.example.foodrecipeapp.databinding.ActivityOnBoardingBinding
import com.example.foodrecipeapp.utils.base.BaseViewBindingActivity

class OnBoardingActivity : BaseViewBindingActivity<ActivityOnBoardingBinding>() {

    private lateinit var introSlideAdapter: IntroSlideAdapter

    override fun createBindingActivity(): ActivityOnBoardingBinding {
        return ActivityOnBoardingBinding.inflate(layoutInflater)
    }

    override fun initData() {
        introSlideAdapter = getIntroSlideAdapter()
    }

    override fun initView() {
        binding.introSlider.adapter = introSlideAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun getIntroSlideAdapter(): IntroSlideAdapter {
        return IntroSlideAdapter(
            listOf(
                IntroSlide(
                    getString(R.string.slogan_1),
                    getString(R.string.slogan_content_1),
                    R.drawable.slide_item_1
                ),
                IntroSlide(
                    getString(R.string.slogan_2),
                    getString(R.string.slogan_content_2),
                    R.drawable.slide_item_2
                ),
                IntroSlide(
                    getString(R.string.slogan_3),
                    getString(R.string.slogan_content_3),
                    R.drawable.slide_item_3
                )
            )
        )
    }
}
