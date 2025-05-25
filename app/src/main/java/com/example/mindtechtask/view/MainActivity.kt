package com.example.mindtechtask.view

import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.mindtechtask.R
import com.example.mindtechtask.databinding.ActivityMainBinding
import com.example.mindtechtask.view.adapters.CarDetailsAdapter
import com.example.mindtechtask.view.adapters.CarImageAdapter
import com.example.mindtechtask.viewModel.MainViewmodel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewmodel by viewModels()
    private lateinit var viewPager: ViewPager2
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CarImageAdapter
    private lateinit var carListAdapter: CarDetailsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.viewPager
        recyclerView = binding.recyclerView



        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.carImages.collectLatest { carDetails ->
                    adapter = CarImageAdapter(carDetails, lifecycleScope)
                    viewPager.adapter = adapter
                    setupIndicators(carDetails.size)
                    carListAdapter = CarDetailsAdapter(carDetails, lifecycleScope)
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    recyclerView.adapter = carListAdapter
                }
            }
        }


        binding.searchBar.addTextChangedListener {
            viewModel.filterCars(it.toString())
        }

    }


    private fun setupIndicators(totalPages: Int) {
        val maxDots = 5
        val dotLayout = binding.dotIndicator
        dotLayout.removeAllViews()

        val dots = Array(maxDots) {
            ImageView(this).apply {
                setImageDrawable(
                    ContextCompat.getDrawable(
                        this@MainActivity, R.drawable.indicator_inactive
                    )
                )
                val params = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(8, 0, 8, 0)
                layoutParams = params
                dotLayout.addView(this)
            }
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                val current = when {
                    totalPages <= maxDots -> position
                    position <= 1 -> position
                    position >= totalPages - 2 -> maxDots - (totalPages - position)
                    else -> 2
                }

                for (i in dots.indices) {
                    dots[i].setImageDrawable(
                        ContextCompat.getDrawable(
                            this@MainActivity,
                            if (i == current) R.drawable.indicator_active else R.drawable.indicator_inactive
                        )
                    )
                }
            }
        })
    }
}

