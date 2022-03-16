package com.salihkinali.haberuygulamasi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.salihkinali.haberuygulamasi.databinding.NewsCardviewBinding

class NewAdapter(private val newList: ArrayList<NewsModel>): RecyclerView.Adapter<NewAdapter.NewCardDesign>() {
    var onItemClick: (NewsModel) -> Unit = {}
    class NewCardDesign(val newsCardviewBinding: NewsCardviewBinding):RecyclerView.ViewHolder(newsCardviewBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewCardDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val newsCardviewBinding = NewsCardviewBinding.inflate(layoutInflater,parent,false)
        return NewCardDesign(newsCardviewBinding)
    }

    override fun onBindViewHolder(holder: NewCardDesign, position: Int) {
       val new = newList[position]
        holder.newsCardviewBinding.newImage.setImageResource(new.newImage)
        holder.newsCardviewBinding.newTitle.text = new.newTitle
        holder.newsCardviewBinding.newDetail.text = new.newDetail

        holder.newsCardviewBinding.root.setOnClickListener {
            onItemClick(new)

        }
    }

    override fun getItemCount(): Int {
      return newList.size
    }

}