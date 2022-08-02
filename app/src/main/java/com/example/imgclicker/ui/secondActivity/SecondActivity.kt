package com.example.imgclicker.ui.secondActivity

import android.os.Bundle
import com.example.imgclicker.R
import com.example.imgclicker.base.BaseActivity
import com.example.imgclicker.databinding.ActivitySecondBinding

class SecondActivity : BaseActivity<ActivitySecondBinding>(ActivitySecondBinding::inflate) {

    private var selectedList: ArrayList<Int> = arrayListOf()
    private lateinit var adapter: SecondAdapter

    override fun initView() {
        adapter = SecondAdapter()
        binding.rvSelectedImg.adapter = adapter
        getImage()
    }

    private fun getImage() {
        selectedList = (intent.getIntegerArrayListExtra(getString(R.string.selectKey)) as ArrayList<Int>)
        adapter.setSelectedList(selectedList)
    }


}