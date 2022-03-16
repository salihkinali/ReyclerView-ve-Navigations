package com.salihkinali.haberuygulamasi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.salihkinali.haberuygulamasi.databinding.FragmentMessageBinding
import com.salihkinali.haberuygulamasi.model.PhoneDirectoryModel


class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding? = null
    private lateinit var selectedListItem: ArrayList<PhoneDirectoryModel>
    private var isSelected: Boolean = false
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Mesajların diziye eklendiği Bölümdür.
        val personList = arrayListOf<PhoneDirectoryModel>(
            PhoneDirectoryModel("Mateo Colman", R.drawable.colman, "Hey Dude, What's up?", "23:48"),
            PhoneDirectoryModel(
                "Servet Gök",
                R.drawable.servet,
                "Salih, Projeyi tamamlayabildin mi?",
                "21:28"
            ),
            PhoneDirectoryModel(
                "Burak Afacan",
                R.drawable.burak,
                "Maça gideceksen haber vermeyi unutma :)",
                "19:35"
            ),
            PhoneDirectoryModel(
                "Pamela Cameron",
                R.drawable.pamela,
                "Dou You hear me guy?",
                "19:05"
            ),
            PhoneDirectoryModel("Bob Kamelon", R.drawable.kamelon, "Come on Dude", "17:40"),
            PhoneDirectoryModel(
                "Selim Kiraz",
                R.drawable.selim,
                "Akşam Eve bize gelirken tatlı getirmeyi unutma :D",
                "08:36"
            )
        )
        val messageAdapter = DirectoryAdapter(personList)
        binding.messageRecyclerView.adapter = messageAdapter
        binding.messageRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.messageRecyclerView.setHasFixedSize(true)
        messageAdapter.onMessageItem = ::onItemClick
        messageAdapter.onMessageSize = ::onMessageClick

    }
    fun onItemClick(choiseItem: PhoneDirectoryModel) {
        val action = MessageFragmentDirections.messageToDetailFragment(
            choiseItem.personImage,
            choiseItem.personName,
            choiseItem.personDate
        )
        Log.e("Gelen Veri--->",choiseItem.personName)
        findNavController().navigate(action)
    }
    fun onMessageClick(gelenMessage: PhoneDirectoryModel){
        Log.e("Seçtiğin Mesajdaki Kişi",gelenMessage.personName)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}



