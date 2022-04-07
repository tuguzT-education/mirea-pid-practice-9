package io.github.tuguzt.recyclerviewexample.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import io.github.tuguzt.recyclerviewexample.databinding.ItemPersonBinding
import io.github.tuguzt.recyclerviewexample.model.Person

class PersonListAdapter : ListAdapter<Person, PersonViewHolder>(PersonDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPersonBinding.inflate(layoutInflater, parent, false)
        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}
