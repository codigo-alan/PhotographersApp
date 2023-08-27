package com.example.photographers.ui.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.photographers.R
import com.example.photographers.data.local.ItemDatabase
import com.example.photographers.databinding.FragmentListBinding
import com.example.photographers.domain.model.Item
import com.example.photographers.ui.adapters.ItemAdapter
import com.example.photographers.ui.adapters.OnClickListener
import com.example.photographers.ui.viewmodel.ListViewModel

class ListFragment : Fragment(), OnClickListener {

    private lateinit var binding: FragmentListBinding
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private val model: ListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = Room.databaseBuilder(
                    requireContext(),
                    ItemDatabase::class.java,
                    "ItemDatabase").build()

        itemAdapter = ItemAdapter(model.items.value!!, this)

        linearLayoutManager = LinearLayoutManager(context)
        binding.recyclerListItems.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = itemAdapter
        }

        model.items.observe(viewLifecycleOwner){
            it?.let { itemAdapter.setItems(it) }
            Log.d("items", "$it") //dev
        }

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_item_scan -> showToast(it.title.toString())
                R.id.menu_item_festivals -> showToast(it.title.toString())
                R.id.menu_item_news -> showToast(it.title.toString())
                R.id.menu_item_favs -> showToast(it.title.toString())
                else -> showToast("Default")
            }

        }

        model.repository.remoteDataSource.itemsRemote.observe(viewLifecycleOwner){
            it?.let{model.saveDataLocal(it,db)}
        }
        model.repository.localDataSource.itemsLocal.observe(viewLifecycleOwner){
            it?.let{model.localFetchData(db)}
        }

    }

    override fun onClick(item: Item) {
        model.setSelectedItem(item)
        findNavController().navigate(R.id.action_listFragment_to_detailFragment)
    }

    private fun showToast(selectedItemTitle: String): Boolean{
        Toast.makeText(requireContext(), selectedItemTitle, Toast.LENGTH_SHORT).show()
        return true
    }

}