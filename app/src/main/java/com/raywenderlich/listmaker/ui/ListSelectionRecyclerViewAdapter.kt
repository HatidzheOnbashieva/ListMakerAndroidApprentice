package com.raywenderlich.listmaker.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.listmaker.models.TaskList
import com.raywenderlich.listmaker.databinding.ListSelectionViewHolderBinding

class ListSelectionRecyclerViewAdapter(private val lists: MutableList<TaskList>) : RecyclerView.Adapter<ListSelectionViewHolder>() {

    //val listTitles = arrayOf("Shopping List", "Chores", "Android Tutorials")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionViewHolder {

        val binding = ListSelectionViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ListSelectionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {
        holder.binding.itemNumber.text = (position+1).toString()
        //holder.binding.itemString.text = listTitles[position]
        holder.binding.itemString.text = lists[position].name
    }

    override fun getItemCount(): Int {
        //return listTitles.size
        return lists.size
    }

    fun listsUpdated(){
        notifyItemInserted(lists.size-1)
    }
}