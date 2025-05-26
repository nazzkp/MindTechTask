package com.example.mindtechtask.view

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mindtechtask.model.CarBrand
import com.example.mindtechtask.viewModel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

@Composable
fun ImageSlider(items: List<CarBrand>) {
    val viewModel : HomeViewModel= viewModel()
    val pager = rememberPagerState(initialPage = 0) {
        items.size
    }

    val currentPage by remember { derivedStateOf { pager.currentPage } }

    val dotCount = 5
    val maxIndex = items.size

    val highlightedDotIndex = when {
        currentPage <= 1 -> currentPage
        currentPage >= maxIndex - 2 -> dotCount - (maxIndex - currentPage)
        else -> 2
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        HorizontalPager(
            state = pager,
        ) { index ->
            CardContent(items[index].brandLogoUrl)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            repeat(dotCount) { index ->
                val isSelected = index == highlightedDotIndex
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(if (isSelected) Color.Blue else Color.Gray)
                )
            }
            viewModel.selectBrand(items[pager.currentPage].brandName)
        }
    }
}


@Composable
fun CardContent(url: String) {
    ImageLoader(url, modifier = Modifier
        .fillMaxWidth()
        .height(250.dp)
        .padding(16.dp)
        .clip(RoundedCornerShape(16.dp)))
}

@Composable
fun ImageLoader(imageUrl: String,modifier: Modifier) {
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    LaunchedEffect(imageUrl) {
        withContext(Dispatchers.IO) {
            try {
                val url = URL(imageUrl)
                val connection = url.openConnection() as HttpURLConnection
                connection.doInput = true
                connection.connect()
                val input = connection.inputStream
                bitmap = BitmapFactory.decodeStream(input)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    bitmap?.let {
        Image(
            bitmap = it.asImageBitmap(),
            contentDescription = "Loaded image",
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
    } ?: run {
        Box(
            modifier = modifier
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Text("Loading...", color = Color.White)
        }
    }
}