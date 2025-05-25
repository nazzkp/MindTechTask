package com.example.mindtechtask.view

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
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
import com.example.mindtechtask.view.adapters.CarBrandAdapter
import com.example.mindtechtask.viewModel.MainViewmodel
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewmodel by viewModels()
    private lateinit var viewPager: ViewPager2
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CarBrandAdapter
    private lateinit var carListAdapter: CarDetailsAdapter
    private lateinit var character: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.viewPager
        recyclerView = binding.recyclerView



        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.carImages.collectLatest { carBrands ->
                    adapter = CarBrandAdapter(carBrands, lifecycleScope)
                    viewPager.adapter = adapter
                    setupIndicators(carBrands.size)
                    viewPager.offscreenPageLimit = 3
                }
            }
        }


        binding.searchBar.addTextChangedListener { it ->
            viewModel.updateSearchQuery(it.toString())
        }

        binding.fab.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.bottom_sheet_layout, null)
            val bottomSheetDialog = BottomSheetDialog(this)
            bottomSheetDialog.setContentView(view)

            val itemsCount = view.findViewById<TextView>(R.id.items_count)
            val characterCount = view.findViewById<TextView>(R.id.character_count)
            val dismissButton = view.findViewById<Button>(R.id.dismissButton)

            val countText = "Item count : " + viewModel.filteredCars.value.size.toString()
            itemsCount.text = countText
            characterCount.text = character



            dismissButton.setOnClickListener {
                bottomSheetDialog.dismiss()
            }

            bottomSheetDialog.show()
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
                super.onPageSelected(position)

                binding.searchBar.setText("")
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
                val brandName = (viewPager.adapter as? CarBrandAdapter)
                    ?.getBrandAt(position)
                    ?.brandName

                brandName?.let {
                    viewModel.selectBrand(it)
                }

                lifecycleScope.launch {
                    repeatOnLifecycle(Lifecycle.State.STARTED) {
                        viewModel.filteredCars.collectLatest { cars ->
                            carListAdapter = CarDetailsAdapter(cars, lifecycleScope)
                            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                            recyclerView.adapter = carListAdapter

                            val allTitles = cars.joinToString("") { it.title }
                            val frequencyMap = allTitles
                                .filter { it.isLetter() }
                                .groupingBy { it.lowercaseChar() }
                                .eachCount()
                                .toList()
                                .sortedByDescending { it.second }
                                .take(3)
                            character =
                                frequencyMap.joinToString("\n") { "${it.first} = ${it.second}" }
                        }
                    }
                }
            }
        })
    }
}

