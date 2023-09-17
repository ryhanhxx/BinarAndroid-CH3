package com.ch.activityfragmentexample.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.ch.activityfragmentexample.model.Person
import com.ch.activityfragmentexample.databinding.ItemListAvangersBinding

class AvengerListAdapter(private val onItemClick: (Person) -> Unit) :
    RecyclerView.Adapter<AvengerItemListViewHolder>() {

    private val differ =  AsyncListDiffer(this,object : DiffUtil.ItemCallback<Person>(){
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    })

    fun setData(data : List<Person>){
        differ.submitList(data)
        notifyItemRangeChanged(0,data.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvengerItemListViewHolder {
        return AvengerItemListViewHolder(
            binding = ItemListAvangersBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            onItemClick = onItemClick
        )
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: AvengerItemListViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

}

class AvengerItemListViewHolder (
    private val binding: ItemListAvangersBinding,
    private val onItemClick: (Person) -> Unit
): ViewHolder(binding.root){
    fun bind(item: Person){
        binding.root.setOnClickListener {
            onItemClick.invoke(item)
        }
        binding.ivProfileImg.load(item.profilePictUrl)
        binding.tvName.text = item.name
    }
}