package com.example.imgclicker.ui.firstActivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imgclicker.databinding.ImgGridBinding

class MainAdapter(private val listener: SelectListener) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private var imgList = arrayListOf<Int>()


    fun setImgList(imgList: ArrayList<Int>) {
        this.imgList = imgList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding: ImgGridBinding =
            ImgGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(imgList[position])
        holder.binding.imgItem.alpha = 1f
        holder.itemView.setOnLongClickListener {
            holder.binding.imgItem.alpha = 0.5f
            listener.select(imgList[position])
            true
        }
    }

    override fun getItemCount(): Int {
        return imgList.size
    }

    class MainViewHolder(val binding: ImgGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(img: Int) {
            binding.imgItem.setImageResource(img)
        }
    }

    interface SelectListener {
        fun select(selectImg: Int)
    }
}