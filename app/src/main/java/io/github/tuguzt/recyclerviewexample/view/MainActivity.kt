package io.github.tuguzt.recyclerviewexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import io.github.tuguzt.recyclerviewexample.R
import io.github.tuguzt.recyclerviewexample.databinding.ActivityMainBinding
import io.github.tuguzt.recyclerviewexample.viewmodel.ListViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: ListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PersonListAdapter()
        binding.list.adapter = adapter

        val spaceSize = resources.getDimensionPixelSize(R.dimen.padding)
        binding.list.addItemDecoration(MarginDecoration(spaceSize))

        viewModel.loadPeople(this)
        viewModel.people.observe(this, adapter::submitList)
    }
}
