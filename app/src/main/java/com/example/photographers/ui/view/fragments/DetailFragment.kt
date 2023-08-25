package com.example.photographers.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.photographers.R
import com.example.photographers.databinding.FragmentDetailBinding
import com.example.photographers.domain.model.Item
import com.example.photographers.ui.viewmodel.ListViewModel
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val model: ListViewModel by activityViewModels() //TODO for the moment only one viewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item: Item? = model.selectedItem.value
        binding.itemInnerDetail.tvName.text = "${item?.firstName} ${item?.lastName}"
        binding.descriptionTv.text = "${item?.description}"

        Picasso.get()
            .load("${item?.image}")
            .error(R.drawable.baseline_broken_image_24)
            .fit()
            .centerCrop()
            .into( binding.itemInnerDetail.ivPhoto)


        //Back button
        binding.toListBtn.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_listFragment)
        }

    }

}