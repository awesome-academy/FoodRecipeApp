package com.example.foodrecipeapp.screen.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.core.view.size
import androidx.viewpager2.widget.ViewPager2
import com.example.foodrecipeapp.R
import com.example.foodrecipeapp.adapter.IntroSlideAdapter
import com.example.foodrecipeapp.data.model.IntroSlide
import com.example.foodrecipeapp.databinding.ActivityOnBoardingBinding
import com.example.foodrecipeapp.screen.home.HomeActivity
import com.example.foodrecipeapp.utils.base.BaseViewBindingActivity

class OnBoardingActivity : BaseViewBindingActivity<ActivityOnBoardingBinding>() {

    private lateinit var introSlideAdapter: IntroSlideAdapter

    override fun createBinding(): ActivityOnBoardingBinding {
        return ActivityOnBoardingBinding.inflate(layoutInflater)
    }

    override fun initData() {
        introSlideAdapter = getIntroSlideAdapter()
    }

    override fun initView() {
        binding.introSlider.adapter = introSlideAdapter

        binding.btnNext.setOnClickListener {
            val currentItem = binding.introSlider.currentItem
            if (currentItem + 1 < introSlideAdapter.itemCount) {
                binding.introSlider.currentItem = currentItem + 1
            } else {
                Intent(applicationContext, HomeActivity::class.java).also {
                    startActivity(it)
                }
            }
        }

        binding.tvSkipIntro.setOnClickListener {
            Intent(applicationContext, HomeActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.introSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupIndicators()
        setCurrentIndicator(0)
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

    private fun setupIndicators() {
        val indicators = arrayOfNulls<ImageView>(introSlideAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(16, 8, 16, 8)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            binding.indicatorsContainer.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = binding.indicatorsContainer.childCount
        for (i in 0 until childCount) {
            val imageView = binding.indicatorsContainer[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }

        if (index == binding.introSlider.size + 1) {
            binding.btnNext.text = getString(R.string.get_started)
            binding.tvSkipIntro.visibility = View.INVISIBLE
        } else {
            binding.btnNext.text = getString(R.string.next)
            binding.tvSkipIntro.visibility = View.VISIBLE
        }
    }
}
