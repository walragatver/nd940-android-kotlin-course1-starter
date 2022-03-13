package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentEditShoeDetailBinding
import com.udacity.shoestore.shoelist.ShoeListModel


/**
 * A simple [Fragment] subclass.
 * Use the [EditShoeDetail.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditShoeDetail : Fragment() {
    val shoeListModel: ShoeListModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentEditShoeDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_shoe_detail, container, false)

        binding.cancelButton.setOnClickListener { view -> view.findNavController().navigate(EditShoeDetailDirections.actionEditShoeDetailToShoeList()) }
        binding.addShoeButton.setOnClickListener {
            view ->
                val shoeName = binding.shoeNameTextInput.text.toString()
                val companyName = binding.companyNameTextInput.text.toString()
                val sizeInput: Int = binding.shoeSizeInput.text.toString().toIntOrNull() ?: 10
                val shoeDescription: String = binding.shoeDescriptionInput.text.toString()
                val newShoeInfo: ShoeListModel.ShoeInfo = ShoeListModel.ShoeInfo(shoeName, companyName, sizeInput, shoeDescription)
                shoeListModel.addShoe(newShoeInfo);
                view.findNavController().navigate(EditShoeDetailDirections.actionEditShoeDetailToShoeList());
        }
        return binding.root
    }
}