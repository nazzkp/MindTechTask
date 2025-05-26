package com.example.mindtechtaskxml.view.adapters

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mindtechtaskxml.R
import com.example.mindtechtaskxml.model.dataClass.Car
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class CarDetailsAdapter(
    private val carsList: List<Car>,
    private val scope: CoroutineScope
) : RecyclerView.Adapter<CarDetailsAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carImage: ImageView = itemView.findViewById(R.id.car_image)
        val carTitle: TextView = itemView.findViewById(R.id.car_brand)
        val carColor: TextView = itemView.findViewById(R.id.car_color)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.car_detail_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageUrl = carsList[position].carImage
        holder.carImage.setImageDrawable(null)
        holder.carColor.text = carsList[position].color
        holder.carTitle.text = carsList[position].title

        scope.launch(Dispatchers.Main) {
            val bitmap = loadBitmapFromUrl(imageUrl)
            if (bitmap != null) {
                holder.carImage.setImageBitmap(bitmap)
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