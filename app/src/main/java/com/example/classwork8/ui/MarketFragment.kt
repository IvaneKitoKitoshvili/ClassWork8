package com.example.classwork8.ui

import android.graphics.Bitmap
import android.os.Bundle
import android.util.LruCache
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.classwork8.adapter.ItemsAdapter
import com.example.classwork8.extensions.launchStarted

abstract class MarketFragment : Fragment() {
    private lateinit var binding: MarketFragment
    private lateinit var activeCoursesAdapter: ItemsAdapter
    abstract val viewModel: MainVM
    private lateinit var memoryCache: LruCache<String, Bitmap>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMarketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAdapters()
        setupObservers()

        val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()
        val cacheSize = maxMemory / 8

        memoryCache = object : LruCache<String, Bitmap>(cacheSize) {

            override fun sizeOf(key: String, bitmap: Bitmap): Int {
                return bitmap.byteCount / 1024
            }
        }
    }

    private fun setupObservers() {
        launchStarted {
            viewModel.defaultState.collect {
                if (it.errorMsg.isNotEmpty()) {
                    Toast.makeText(this, it.errorMsg, Toast.LENGTH_SHORT).show()
                }
//                activeCoursesAdapter.submitList(it.data?.activeCourses?.map { it.toModel() }
//                    ?: emptyList())
//                newCoursesAdapter.submitList(it.data?.newCourses?.map { it.toModel() }
//                    ?: emptyList())
            }
        }
        launchStarted {
            viewModel.state.collect{
                activeCoursesAdapter.submitList(it.activeCourses)
                ItemsAdapter.submitList(it.newCourses)
            }
        }
    }

    private fun setupAdapters() {
        with(binding) {
            activeCoursesAdapter = ItemsAdapter()
            rvActiveCourses.adapter = activeCoursesAdapter
            rvActiveCourses.layoutManager = LinearLayoutManager(this@MainActivity)

            ItemsAdapter = NewItemsAdapter()
            rvNewCourses.adapter = newCoursesAdapter
            rvNewCourses.layoutManager =
                LinearLayoutManager(this@MarketFragment, LinearLayoutManager.HORIZONTAL, false)
        }
    }
}
