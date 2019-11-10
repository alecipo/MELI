package com.example.test.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.ProductAdapter
import com.example.test.R
import com.example.test.models.Results
import com.example.test.models.SearchResponse
import com.example.test.services.MeliServices
import com.example.test.services.RetrofitClientInstance
import kotlinx.android.synthetic.main.fragment_results.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultsFragment : Fragment(R.layout.fragment_results), ProductAdapter.ItemClickListener {

    lateinit var navController: NavController
    lateinit var productAdapter: ProductAdapter
    private var items: List<Results> = ArrayList()
    private val args: ResultsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productAdapter = ProductAdapter(this)
        addData()
        navController = Navigation.findNavController(view)
    }


    private fun addData() {
        val service = RetrofitClientInstance.retrofitInstance.create(MeliServices::class.java)
        val call = service.getBySearch(args.busqueda)
        call.enqueue(object : Callback<SearchResponse> {
            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                items = response.body()!!.results
                productAdapter.submitList(items.toList())
                initRecyclerView()
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })

    }

    private fun initRecyclerView() {
        resultsRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = productAdapter
        }
    }

    override fun onProdClick(pos: Int) {
        val action = ResultsFragmentDirections.actionResultsFragmentToDetailsFragment(items[pos])
        navController.navigate(action)
    }
}
