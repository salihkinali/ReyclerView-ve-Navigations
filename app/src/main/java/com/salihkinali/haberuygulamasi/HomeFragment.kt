package com.salihkinali.haberuygulamasi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.salihkinali.haberuygulamasi.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
     private val icerik = "Son dakika: Brent petrolün fiyatı Rusya-Ukrayna savaşıyla yükselişini " +
             "sürdürürken, bu gelişme Türkiye'de akaryakıta zam olarak yansımaya devam ediyor. " +
             "Son bir haftada 4 kez zamlanan benzin ve motorinin fiyatı bir kez daha arttı. Bu" +
             " gece yarısından itibaren geçerli olmak üzere benzinin litresi 1 lira 7 kuruş, " +
             "motorinin litresi ise 1 lira 59 kuruş arttı. Zam sonrası benzinin fiyatı 20 " +
             "lirayı aştı, motorinin fiyatı ise 23 lira sınırına dayandı."
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Hava Durumunun Oluşturulduğu Dizinin alanıdır.

      val weatherList = arrayListOf<WeatherModel>(
          WeatherModel(R.drawable.ankara,"Ankara","Bulutlu 16 °C"),
          WeatherModel(R.drawable.bursa,"Bursa","Güneşli 25 °C"),
          WeatherModel(R.drawable.erzurum,"Erzurum","Karlı -15 °C"),
          WeatherModel(R.drawable.trabzon,"Trabzon","Yağmurlu 8 °C"),
          WeatherModel(R.drawable.kutahya,"Kütahya","Rüzgarlı 10°C"),
          WeatherModel(R.drawable.izmir,"İzmir","Güneşli 28 °C")
      )
        //Haberlerin Oluşturulduğu Dizinin alanıdır.
        val newList = arrayListOf<NewsModel>(
            NewsModel(R.drawable.akaryakit,"Son bir haftada Akaryakıta 5. Zam!",icerik),
            NewsModel(R.drawable.istanbul_news,"İstanbulda Kar Alarmı! AFAD Açıkladı.",icerik),
            NewsModel(R.drawable.superlig,"TFF, yayın ihalesi için Digiturk ile anlaşma sağlayamadı. ",icerik),
            NewsModel(R.drawable.sezon,"Türkiye'nin meyve ve sebze üretim merkezlerinden can erikte turfanda ilk hasat yapıldı.",icerik)
        )
        //Hava Adapterın Bağlandığı Bölümdür.
        val weatherAdapter = WeatherAdapter(weatherList)
        binding.havaDurumuRecyler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.havaDurumuRecyler.adapter = weatherAdapter




        // News Adapterin Bağlandığı Alandır.
        val newAdapter = NewAdapter(newList)
        binding.newRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        binding.newRecyclerView.adapter = newAdapter
        binding.newRecyclerView.setHasFixedSize(true)
        newAdapter.onItemClick = ::choiseNew
    }
    fun choiseNew(choiseNews:NewsModel){

        Log.e("Seçilen Haber Kısmı:",choiseNews.newTitle)
        val pass = HomeFragmentDirections.homeToDetayFragment(choiseNews.newImage,choiseNews.newTitle,choiseNews.newDetail)
        findNavController().navigate(pass)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}