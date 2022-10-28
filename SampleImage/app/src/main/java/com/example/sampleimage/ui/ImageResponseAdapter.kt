package com.example.sampleimage.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.sampleimage.databinding.ItemViewLayoutBinding
import com.example.sampleimage.models.ImageResponseModelItem

class ImageResponseAdapter : RecyclerView.Adapter<ImageResponseAdapter.ImageResponseViewHolder>() {

    inner class ImageResponseViewHolder(private val binding: ItemViewLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setBinding(data: ImageResponseModelItem) {
            binding.imageView.load(
                data.url
            )
        }
    }

    private val getDiffUtilCallback = object : DiffUtil.ItemCallback<ImageResponseModelItem>() {
        override fun areItemsTheSame(
            oldItem: ImageResponseModelItem,
            newItem: ImageResponseModelItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ImageResponseModelItem,
            newItem: ImageResponseModelItem
        ): Boolean {
            return oldItem == newItem
        }
    }
    val diff = AsyncListDiffer(this, getDiffUtilCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageResponseViewHolder {
        return ImageResponseViewHolder(
            ItemViewLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ImageResponseViewHolder, position: Int) {
        val data = diff.currentList[position]
        holder.setBinding(data)
    }

    override fun getItemCount(): Int {
        return diff.currentList.size
    }
}