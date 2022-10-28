package com.example.sampleimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.sampleimage.databinding.ActivityMainBinding
import com.example.sampleimage.models.ImageResponseModelItem
import com.example.sampleimage.ui.ImageResponseAdapter
import com.example.sampleimage.ui.ImageViewModel
import com.example.sampleimage.util.Constant
import com.example.sampleimage.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var imageAdapter: ImageResponseAdapter
    private val imageViewModel by viewModels<ImageViewModel>()

    val list = mutableListOf<ImageResponseModelItem>()

    companion object {
        var page = 1
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imageViewModel.gettingImages(20, 1, Constant.ORDER) // api calling
        setRecyclerData()
        getObserverData()
        setPagination()
    }

    /*
    Setting the pagination
     */
    private fun setPagination() {
        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!recyclerView.canScrollVertically(1) && dy > 0) {
                    imageViewModel.gettingImages(10, ++page, Constant.ORDER) //api calling
                }

            }
        })
    }


    /*
    Setting RecyclerView
     */
    private fun setRecyclerData() {
        imageAdapter = ImageResponseAdapter()
        binding.recyclerView.apply {
            adapter = imageAdapter
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        }
    }


    /*
    Subscribing the obeservable data
     */
    private fun getObserverData() {
        imageViewModel.imageResponseLiveData.observe(this) {
            when (it) {
                is NetworkResult.Success -> {
                    binding.progressCircularBar.visibility = View.GONE
                    it.data?.let {
                        list.addAll(it)
                        imageAdapter.diff.submitList(list)
                        imageAdapter.notifyDataSetChanged()
                    }
                }

                is NetworkResult.Error -> {
                    binding.progressCircularBar.visibility = View.GONE
                }
                is NetworkResult.Loading -> {
                    binding.progressCircularBar.visibility = View.VISIBLE
                }
            }
        }
    }
}