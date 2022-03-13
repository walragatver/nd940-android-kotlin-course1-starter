package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentEditShoeDetailBinding
import com.udacity.shoestore.shoelist.ShoeInfo
import com.udacity.shoestore.shoelist.ShoeInfoModelFactory
import com.udacity.shoestore.shoelist.ShoeListModel


/**
 * A simple [Fragment] subclass.
 * Use the [EditShoeDetail.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditShoeDetail : Fragment() {
    val shoeListModel: ShoeListModel by activityViewModels()
    private lateinit var viewModel: ShoeInfo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentEditShoeDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_shoe_detail, container, false)
        val viewModelFactory = ShoeInfoModelFactory("", "", "", "")
        viewModel = ViewModelProvider(this, viewModelFactory).get(ShoeInfo::class.java)
        binding.newShoeInfo = viewModel

        binding.cancelButton.setOnClickListener { view -> view.findNavController().navigate(EditShoeDetailDirections.actionEditShoeDetailToShoeList()) }
        binding.addShoeButton.setOnClickListener {
            view ->
                shoeListModel.addShoe(viewModel);
                view.findNavController().navigate(EditShoeDetailDirections.actionEditShoeDetailToShoeList());
        }
        return binding.root
    }
}