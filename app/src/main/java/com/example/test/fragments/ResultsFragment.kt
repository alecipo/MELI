package com.example.test.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.ProductAdapter
import com.example.test.R
import com.example.test.models.SearchResponse
import com.example.test.services.GetDataService
import com.example.test.services.RetrofitClientInstance
import kotlinx.android.synthetic.main.fragment_results.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        productAdapter = ProductAdapter()
        addData()
        navController = Navigation.findNavController(view)
        //btnToDetails.setOnClickListener(this)
    }


    private fun addData() {
        val service = RetrofitClientInstance.retrofitInstance.create(GetDataService::class.java)
        val call = service.getBySearch("iphone")
        call.enqueue(object : Callback<SearchResponse> {
            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                val resultados = response.body()
                productAdapter.submitList(resultados!!.results.toList())
                initRecyclerView()
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                print("fallo")
            }
        })

    }

    private fun initRecyclerView() {
        resultsRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = productAdapter
        }
    }


}
