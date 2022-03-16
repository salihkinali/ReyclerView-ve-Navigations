package com.salihkinali.haberuygulamasi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salihkinali.haberuygulamasi.databinding.HavaCardviewBinding

class WeatherAdapter(private var weatherList:ArrayList<WeatherModel>): RecyclerView.Adapter<WeatherAdapter.WeatherCardDesign>() {

    class WeatherCardDesign(val havaCardviewBinding: HavaCardviewBinding):RecyclerView.ViewHolder(havaCardviewBinding.root){

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherCardDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cardviewBinding = HavaCardviewBinding.inflate(layoutInflater, parent, false)
        return WeatherCardDesign(cardviewBinding)
    }

    override fun onBindViewHolder(holder: WeatherCardDesign, position: Int) {

        val hava = weatherList[position]
        holder.havaCardviewBinding.havaImage.setImageResource(hava.weatherImage)
        holder.havaCardviewBinding.cityName.text = hava.city
        holder.havaCardviewBinding.state.text = hava.weatherState

    }

    override fun getItemCount(): Int {
      return weatherList.size
    }

}