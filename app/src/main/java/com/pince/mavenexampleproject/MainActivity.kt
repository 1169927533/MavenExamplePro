package com.pince.mavenexampleproject

import com.pince.mavenexampleproject.bottomexample.BottomTabActivity
import com.uppack.lksmall.baseyu.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        btn_bottomtab.setOnClickListener { startActivity<BottomTabActivity>(this@MainActivity) }
    }

    override fun initViewData() {
    }

    override fun observeLiveData() {
    }


}