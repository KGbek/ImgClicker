package com.example.imgclicker.ui.firstActivity

import android.content.Intent
import com.example.imgclicker.R
import com.example.imgclicker.base.BaseActivity
import com.example.imgclicker.databinding.ActivityMainBinding
import com.example.imgclicker.ext.showToast
import com.example.imgclicker.ui.secondActivity.SecondActivity
import java.util.Collections.emptyList

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate),
    MainAdapter.SelectListener {
    private lateinit var adapter: MainAdapter
    private var list: ArrayList<Int> = arrayListOf()
    private var selectedList: ArrayList<Int> = arrayListOf()

    override fun initListener() {
        binding.btnForward.setOnClickListener {
            if (selectedList.isNullOrEmpty()) {
                showToast(getString(R.string.emptyList))

            } else {
                resetSelected()
                openActivity()
                selectedList.clear()
            }
        }
    }

    private fun openActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putIntegerArrayListExtra(getString(R.string.selectKey), selectedList)
        startActivity(intent)
    }

    private fun resetSelected() {
        for (i in 0..list.lastIndex) {
            adapter.notifyItemChanged(i)
        }
    }

    override fun initView() {
        adapter = MainAdapter(this)
        binding.recycler.adapter = adapter
        adapter.setImgList(list)
        initList()
    }

    private fun initList() {
        list.add(R.drawable.img_1)
        list.add(R.drawable.img_1)
        list.add(R.drawable.img_1)
        list.add(R.drawable.img_2)
        list.add(R.drawable.img_3)
        list.add(R.drawable.img_1)
        list.add(R.drawable.img_2)
        list.add(R.drawable.img_3)
        list.add(R.drawable.img_1)
        list.add(R.drawable.img_2)
        list.add(R.drawable.img_3)
        list.add(R.drawable.img_1)
        list.add(R.drawable.img_2)
        list.add(R.drawable.img_3)
        list.add(R.drawable.img_1)
    }

    override fun select(selectImg: Int) {
        selectedList.add(selectImg)
    }
}