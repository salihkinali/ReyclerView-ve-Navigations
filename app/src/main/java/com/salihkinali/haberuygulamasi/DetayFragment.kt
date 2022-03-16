package com.salihkinali.haberuygulamasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.salihkinali.haberuygulamasi.databinding.FragmentDetayBinding


class DetayFragment : Fragment() {
    private var _binding: FragmentDetayBinding? = null
    private val binding get() = _binding!!
    private val args: DetayFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gelenPass = args
        binding.newImages.setImageResource(gelenPass.newImagesId)
        binding.detayTittle.text = gelenPass.tittle
        binding.detayNew.text = gelenPass.newdetail

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}