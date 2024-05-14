package com.example.hayatapp.ui.regetir


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hayatapp.R
import com.example.hayatapp.data.UserTypeData
import com.example.hayatapp.databinding.UserTypeItemBinding

class UserTypeAdapter(private val clickListener: ItemsClickEvents) :
    ListAdapter<UserTypeData, UserTypeAdapter.ViewHolder>(ItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = UserTypeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(clickListener, item)
    }

    inner class ViewHolder(private val binding: UserTypeItemBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(clickListener: ItemsClickEvents, item: UserTypeData?) {
            binding.data = item
            binding.clickEvents = clickListener
            binding.executePendingBindings()

            // Update UI based on the selected state
            binding.image.setImageResource(if (item?.isSelected == true) R.drawable.group846 else R.drawable.ellipse37)
            binding.img.setBackgroundResource(if (item?.isSelected == true) R.drawable.border_background_gray else 0)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val item = getItem(position)
                item?.let {
                    clickListener.selected(it)
                }
            }
        }
    }

    interface ItemsClickEvents {
        fun selected(data: UserTypeData)
        fun deselectOthers(data: UserTypeData)
    }

    class ItemDiffCallback : DiffUtil.ItemCallback<UserTypeData>() {
        override fun areItemsTheSame(oldItem: UserTypeData, newItem: UserTypeData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: UserTypeData, newItem: UserTypeData): Boolean {
            return oldItem == newItem
        }
    }
}
