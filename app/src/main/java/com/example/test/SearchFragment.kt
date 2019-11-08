package com.example.test

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_search.*

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment(R.layout.fragment_search), View.OnClickListener {

    lateinit var navController: NavController

    override fun onClick(v: View?) {
        navController.navigate(R.id.action_searchFragment_to_resultsFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnToResults.setOnClickListener(this)
    }

}
