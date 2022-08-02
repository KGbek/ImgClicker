package com.example.imgclicker.ui.secondActivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imgclicker.databinding.SelectedItemBinding

class SecondAdapter: RecyclerView.Adapter<SecondAdapter.ViewHolder>() {

    private var selectList = arrayListOf<Int>()

    fun setSelectedList(selectList: ArrayList<Int>){
        this.selectList = selectList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: SelectedItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(img: Int){
            binding.imgSelectItem.setImageResource(img)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: SelectedItemBinding = SelectedItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(selectList[position])
    }

    override fun getItemCount(): Int = selectList.size


}