package com.salihkinali.haberuygulamasi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.salihkinali.haberuygulamasi.databinding.FragmentMessageDetailBinding


class MessageDetailFragment : Fragment() {
   private var _binding:FragmentMessageDetailBinding? = null
    private val binding get() = _binding!!
   private val args:MessageDetailFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      _binding = FragmentMessageDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.profilImage.setImageResource(args.profileImage)
        binding.profilname.text = args.profileName
        binding.lastSeen.text = "Son Görülmesi:"+args.profileDate
       binding.back.setOnClickListener { popBackStack() }


    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
    fun popBackStack(){
        findNavController().popBackStack()
    }

}