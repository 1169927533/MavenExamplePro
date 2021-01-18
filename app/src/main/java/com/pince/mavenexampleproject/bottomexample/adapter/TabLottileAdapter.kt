package com.example.module_tabview.adapter

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.viewpager.widget.ViewPager
import com.airbnb.lottie.LottieAnimationView
import com.example.module_tabview.LottileBean
import com.pince.mavenexampleproject.R
import com.uppack.lksmall.baseyu.weight.customtab.BaseTabAdapter

/**
 * @Author Yu
 * @Date 2021/1/18 11:03
 * @Description 展示lottile动画的adapter
 */
class TabLottileAdapter(
    var listTitles: List<LottileBean>,
    viewPager: ViewPager
) :
    BaseTabAdapter(listTitles, viewPager) {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun getView(context: Context, position: Int): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_lottile, null, false)

        var lottieAnimalView = view.findViewById<LottieAnimationView>(R.id.lottie_icon)
        var iconImageView = view.findViewById<ImageView>(R.id.icon)
        var nameTextView = view.findViewById<TextView>(R.id.name)
        initLottieAnimal(
            lottieAnimalView,
            listTitles[position].lottieJson,
            listTitles[position].lottieFile
        )
        iconImageView.setImageResource(listTitles[position].src)
        nameTextView.text = listTitles[position].text

        view.setOnClickListener {
            clickItem(position)
        }
        return view
    }

    override fun onPageSelected(position: Int) {
        for ((index, value) in targetListView.withIndex()) {
            var lottieAnimalView = value.findViewById<LottieAnimationView>(R.id.lottie_icon)
            var iconImageView = value.findViewById<ImageView>(R.id.icon)
            var nameTextView = value.findViewById<TextView>(R.id.name)

            if (index == position) {
                iconImageView.visibility = View.GONE
                lottieAnimalView.visibility = View.VISIBLE
                lottieAnimalView.playAnimation()
                nameTextView.setTextColor(Color.BLACK)

            } else {
                lottieAnimalView.cancelAnimation()
                lottieAnimalView.visibility = View.GONE
                iconImageView.visibility = View.VISIBLE
                nameTextView.setTextColor(Color.GRAY)

            }
        }

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun initLottieAnimal(
        lottieAnimalView: LottieAnimationView,
        mLottieJson: String,
        mLottieFile: String
    ) {
        lottieAnimalView.visibility = View.VISIBLE
        lottieAnimalView.setAnimation(mLottieJson)
        lottieAnimalView.imageAssetsFolder = mLottieFile
    }
}