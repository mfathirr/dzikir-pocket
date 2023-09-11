package com.thir.doadandzikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.thir.doadandzikirapp.adapter.DoaDzikirAdapter
import com.thir.doadandzikirapp.model.DataDoaDzikir.listQauliyah
import com.thir.doadandzikirapp.databinding.ActivityQauliyahShalatBinding

class QauliyahShalatActivity : AppCompatActivity() {
    // implement viewBinding feature
    // viewBinding is a feature that makes it easier to write code that interacts with view
    // viewBinding comes to replace findViewById

    private var _binding: ActivityQauliyahShalatBinding? = null
    private val binding get() = _binding as ActivityQauliyahShalatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // initialize property of _binding with layoutInflater to get the layout
        _binding = ActivityQauliyahShalatBinding.inflate(layoutInflater)
        // replace argument of setContentView using viewBinding
        // this is for connect the view using binding
        // root use for access parent layout
        setContentView(binding.root)

        // set recyclerView
        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(listQauliyah)
        binding.rvQauliyahShalat.adapter = mAdapter
        // layoutManager is a class to set our structure of recyclerView to display dataset
        binding.rvQauliyahShalat.layoutManager = LinearLayoutManager(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}