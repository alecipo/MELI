package com.example.test

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_results.*

/**
 * A simple [Fragment] subclass.
 */

class ResultsFragment : Fragment(R.layout.fragment_results), View.OnClickListener {

    lateinit var navController: NavController
    lateinit var productAdapter: ProductAdapter

    override fun onClick(v: View?) {
        navController.navigate(R.id.action_resultsFragment_to_detailsFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initRecyclerView()
        addData()

        //btnToDetails.setOnClickListener(this)
    }

    private fun addData() {
        //TODO: Buscar la Data
        //val data =
        //productAdapter.submitList(data)
    }

    private fun initRecyclerView() {
        resultsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = ProductAdapter()
        }
    }


}
