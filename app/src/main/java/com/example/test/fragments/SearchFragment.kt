package com.example.test.fragments

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.test.R

class SearchFragment : Fragment(R.layout.fragment_search) {

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        var editText: EditText = activity!!.findViewById(R.id.search_text)

        editText.setOnEditorActionListener { _, action, _ ->
            if (action == EditorInfo.IME_ACTION_SEARCH) {
                val action2 =
                    SearchFragmentDirections.actionSearchFragmentToResultsFragment(editText.text.toString())
                navController.navigate(action2)
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
    }

}
