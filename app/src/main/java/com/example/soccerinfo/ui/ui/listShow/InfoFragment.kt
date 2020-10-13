package com.example.soccerinfo.ui.ui.listShow

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soccerinfo.R
import com.example.soccerinfo.adapter.CustomAdapter
import com.example.soccerinfo.model.InfoResponse
import kotlinx.android.synthetic.main.info_fragment.*

class InfoFragment : Fragment() {

    companion object {
        fun newInstance() = InfoFragment()
    }

    private lateinit var viewModel: InfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InfoViewModel::class.java)
        viewModel.requestForInfo()
        getObserver()
    }

    private fun getObserver() {
        viewModel.infoResponse.observe(viewLifecycleOwner, {
            setAdapter(it)
        })
    }

    private fun setAdapter(it: InfoResponse) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = context?.let { it1 -> CustomAdapter(it1, it.results.resources) }

    }

}