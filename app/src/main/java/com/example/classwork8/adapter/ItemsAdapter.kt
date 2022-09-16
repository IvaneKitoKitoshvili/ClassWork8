package com.example.classwork8.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.classwork8.data.models.ItemsData
import com.example.classwork8.databinding.FragmentMarketBinding
import com.gabo.quiz7.databinding.ActiveCoursesItemViewBinding
import com.gabo.quiz7.domain.models.ActiveCoursesModel
import com.gabo.quiz7.extensions.loadImage

class ItemsAdapter() :
    RecyclerView.Adapter<ItemsAdapter.ActiveCoursesVH>() {
    private var list: List<ItemsAdapter> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<ItemsData>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class ActiveCoursesVH(private val binding: FragmentMarketBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: ItemsData) {
            with(binding) {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveCoursesVH {
        val binding =
            FragmentMarketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActiveCoursesVH(binding)
    }

    override fun onBindViewHolder(holder: ActiveCoursesVH, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size
}