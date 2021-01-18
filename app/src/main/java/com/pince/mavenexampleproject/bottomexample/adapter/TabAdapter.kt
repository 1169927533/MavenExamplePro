package com.example.module_tabview.adapter

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.pince.mavenexampleproject.R
import com.uppack.lksmall.baseyu.weight.customtab.BaseTabAdapter

/**
 * @Author Yu
 * @Date 2021/1/18 11:03
 * @Description TODO
 */
class TabAdapter(
    var listTitles: List<String>,
    var listImage: List<Int>,
    viewPager: ViewPager
) :
    BaseTabAdapter(listTitles, viewPager) {

    override fun getView(context: Context, position: Int): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_tabview, null, false)
        var imageView = view.findViewById<ImageView>(R.id.item_img)
        imageView.setImageResource(listImage[position])
        var textView = view.findViewById<TextView>(R.id.item_tv)
        textView.text = listTitles[position]

        view.setOnClickListener {
            clickItem(position)
        }
        return view
    }

    override fun onPageSelected(position: Int) {
        for ((index, value) in targetListView.withIndex()) {
            var imageView = value.findViewById<ImageView>(R.id.item_img)
            var textView = value.findViewById<TextView>(R.id.item_tv)

            if (index == position) {
                imageView.isSelected = true
                textView.setTextColor(Color.BLACK)
                textView.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
            } else {
                imageView.isSelected = false
                textView.typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
                textView.setTextColor(Color.RED)
            }
        }

    }

    override fun clickItem(position: Int) {
        super.clickItem(position)
        showTabSelectAnima(targetListView[position])
    }
    //给item添加动画
    private fun showTabSelectAnima(view: View) {
        var scaleY = ObjectAnimator.ofFloat(view, "scaleY", 0.8f, 1f)
        var scaleX = ObjectAnimator.ofFloat(view, "scaleX", 0.8f, 1f)
        var setAnima = AnimatorSet()
        setAnima.play(scaleX).with(scaleY)
        setAnima.duration = 500
        setAnima.start()
    }
}