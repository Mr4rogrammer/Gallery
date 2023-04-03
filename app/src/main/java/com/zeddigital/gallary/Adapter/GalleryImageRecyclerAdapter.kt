package com.zeddigital.gallary.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.zeddigital.gallary.Model.GalleryDataModel
import com.zeddigital.gallary.R


class GalleryImageRecyclerAdapter(var ctx: Context, galleryData: List<GalleryDataModel>) :
    RecyclerView.Adapter<GalleryImageRecyclerAdapter.Holder>() {
    private var localGalleryData: List<GalleryDataModel>

    init {
        localGalleryData = galleryData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.image_child, parent, false)
        return Holder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        Picasso.get().load(localGalleryData[position].url).into(holder.image);
        Picasso.get().load(localGalleryData[position].thumbnailUrl).into(holder.thumbnail);
        holder.title.text = localGalleryData[position].title

    }

    override fun getItemCount(): Int {
        return localGalleryData.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var thumbnail: ImageView
        var title: TextView

        init {
            image = itemView.findViewById(R.id.image)
            thumbnail = itemView.findViewById(R.id.thumbnail)
            title = itemView.findViewById(R.id.title)
        }
    }

}