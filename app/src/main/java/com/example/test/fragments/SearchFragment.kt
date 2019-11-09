package com.example.test.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.test.R
import kotlinx.android.synthetic.main.fragment_search.*

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment(R.layout.fragment_search), View.OnClickListener {

    private lateinit var navController: NavController

    override fun onClick(v: View?) {
//        val action= SearchFragmentDirections.actionSearchFragmentToResultsFragment()
//        navController.navigate(action)
        navController.navigate(R.id.action_searchFragment_to_resultsFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnToResults.setOnClickListener(this)

        //activity.find
    }


}
