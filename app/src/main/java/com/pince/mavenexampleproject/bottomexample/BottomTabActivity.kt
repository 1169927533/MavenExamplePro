package com.pince.mavenexampleproject.bottomexample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.module_tabview.LottileBean
import com.example.module_tabview.adapter.TabAdapter
import com.example.module_tabview.adapter.TabLottileAdapter
import com.example.module_tabview.fragment.ItemFragmetn
import com.pince.mavenexampleproject.R
import com.uppack.lksmall.baseyu.BaseActivity
import kotlinx.android.synthetic.main.activity_bottom.*

/**
 * @Author Yu
 * @Date 2021/1/18 16:10
 * @Description TODO
 */
class BottomTabActivity : BaseActivity() {
    var items = arrayListOf<String>("主页", "附近", "消息", "我的")
    lateinit var itemLottile:ArrayList<LottileBean>
    var imgList = arrayListOf<Int>(
        R.drawable.select_home,
        R.drawable.select_nearly,
        R.drawable.select_message,
        R.drawable.select_my
    )
    override fun getLayoutId(): Int {
        return R.layout.activity_bottom
    }

    override fun initView() {
        initViewPager()
        initTab()
    }

    override fun initViewData() {
    }

    override fun observeLiveData() {
    }
    private fun initViewPager() {
        viewpager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return ItemFragmetn.newInstance(items[position])
            }

            override fun getCount(): Int {
                return items.count()
            }
        }
    }

    private fun initTab() {
        var tab = TabAdapter(items, imgList, viewpager)
        bottomTab.initBottomTabData(tab, viewpager, 0)


        itemLottile = ArrayList()
        var lottileBean = LottileBean("消息",R.drawable.select_message,"tab_chat.json","chat/images")
        itemLottile.add(lottileBean)
        lottileBean = LottileBean("心动",R.drawable.select_home,"tab_heartbeat.json","home/heartbeat/images")
        itemLottile.add(lottileBean)
        lottileBean = LottileBean("相遇",R.drawable.select_my,"tab_home.json","home/images")
        itemLottile.add(lottileBean)
        lottileBean = LottileBean("派对",R.drawable.select_nearly,"tab_party.json","party/images")
        itemLottile.add(lottileBean)

        var tabLottile = TabLottileAdapter(itemLottile,viewpager)
        bottomTabLottile.initBottomTabData(tabLottile, viewpager, 0)

    }
}