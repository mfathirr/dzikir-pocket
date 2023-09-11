package com.thir.doadandzikirapp.presentation.pagipetang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.thir.doadandzikirapp.adapter.DoaDzikirAdapter
import com.thir.doadandzikirapp.databinding.ActivityDzikirPagiBinding
import com.thir.doadandzikirapp.model.DataDoaDzikir

class DzikirPagiActivity : AppCompatActivity() {
    private var _binding: ActivityDzikirPagiBinding? = null
    private val binding get() = _binding as ActivityDzikirPagiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityDzikirPagiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(DataDoaDzikir.listDzikirPagi())
        binding.rvDzikirPagi.adapter = mAdapter
        binding.rvDzikirPagi.layoutManager = LinearLayoutManager(this)
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