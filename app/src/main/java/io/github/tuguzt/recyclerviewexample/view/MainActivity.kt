package io.github.tuguzt.recyclerviewexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import io.github.tuguzt.recyclerviewexample.R
import io.github.tuguzt.recyclerviewexample.databinding.ActivityMainBinding
import io.github.tuguzt.recyclerviewexample.viewmodel.ListViewModel
import io.github.tuguzt.recyclerviewexample.viewmodel.ListViewModel.SortBy

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: ListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val adapter = PersonListAdapter()
        binding.list.adapter = adapter

        val spaceSize = resources.getDimensionPixelSize(R.dimen.padding)
        binding.list.addItemDecoration(MarginDecoration(spaceSize))

        viewModel.loadPeople(this)
        viewModel.people.observe(this, adapter::submitList)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.list_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.sort_by_name -> {
            viewModel.sortPeople(SortBy.Name)
            true
        }
        R.id.sort_by_sex -> {
            viewModel.sortPeople(SortBy.Sex)
            true
        }
        R.id.sort_by_phone_number -> {
            viewModel.sortPeople(SortBy.PhoneNumber)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
