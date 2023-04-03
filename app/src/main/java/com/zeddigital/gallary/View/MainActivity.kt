package com.zeddigital.gallary.View

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zeddigital.gallary.Adapter.GalleryImageRecyclerAdapter
import com.zeddigital.gallary.Model.GalleryDataModel
import com.zeddigital.gallary.R
import com.zeddigital.gallary.ViewModel.GalleryViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : GalleryViewModel
    private lateinit var adapter : GalleryImageRecyclerAdapter
    private  var imageData: MutableList<GalleryDataModel> = mutableListOf()

    private lateinit var warning :TextView
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[GalleryViewModel::class.java]

        warning = findViewById(R.id.warning)
        initRecyclerView()

        viewModel.listOfImages.observe(this){
            if(it.isEmpty()){
                warning.visibility = View.VISIBLE
            } else{
                warning.visibility = View.GONE
            }
            imageData.clear()
            imageData.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.image_recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = GalleryImageRecyclerAdapter(this,imageData)
        recyclerView.adapter = adapter
    }
}