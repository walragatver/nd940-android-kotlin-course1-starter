package com.udacity.shoestore.shoelist

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeInfoItemBinding
import kotlinx.android.synthetic.main.shoe_info_item.*


class ShoeList : Fragment() {
    val shoeListModel: ShoeListModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment.
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        shoeListModel.shoeList.observe(viewLifecycleOwner, Observer {
            newList ->
            val shoeListContainer =  binding.verticalShoeListLayout
            for (i in newList.indices) {
                val shoeItemBinding: ShoeInfoItemBinding = DataBindingUtil.inflate(inflater, R.layout.shoe_info_item, null, false)
                shoeItemBinding.shoeDescription.text = newList[i].description
                shoeItemBinding.shoeName.text = "${newList[i].companyName}: ${newList[i].shoeName}"
                shoeItemBinding.sizeInfoText.text = "Size: ${newList[i].shoeSize}"

                shoeListContainer.addView(shoeItemBinding.root)
            }
        })

        binding.fab.setOnClickListener { view -> view.findNavController().navigate(ShoeListDirections.actionShoeListToEditShoeDetail()) }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = view!!.findNavController()

        when (item.itemId) {
            R.id.loginFragment -> navController.popBackStack(R.id.loginFragment, false)
        }

        return NavigationUI.onNavDestinationSelected(item!!, navController) || super.onOptionsItemSelected(item)
    }
}