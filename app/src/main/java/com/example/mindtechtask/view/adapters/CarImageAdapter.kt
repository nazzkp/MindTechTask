package com.example.mindtechtask.view.adapters

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.mindtechtask.R
import com.example.mindtechtask.model.dataClass.Car
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class CarImageAdapter(
    private val carsList: List<Car>,
    private val scope: CoroutineScope
) : RecyclerView.Adapter<CarImageAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageUrl = carsList[position].imageLink
        holder.imageView.setImageDrawable(null)

        scope.launch(Dispatchers.Main) {
            val bitmap = loadBitmapFromUrl(imageUrl)
            if (bitmap != null) {
                holder.imageView.setImageBitmap(bitmap)
            }
        }
    }

    override fun getItemCount(): Int = carsList.size

    private suspend fun loadBitmapFromUrl(urlString: String): Bitmap? =
        withContext(Dispatchers.IO) {
            try {
                val url = URL(urlString)
                val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
                connection.doInput = true
                connection.connect()
                val inputStream: InputStream = connection.inputStream
                BitmapFactory.decodeStream(inputStream)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
}