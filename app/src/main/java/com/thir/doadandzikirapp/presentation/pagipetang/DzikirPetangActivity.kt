package com.thir.doadandzikirapp.presentation.pagipetang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.thir.doadandzikirapp.adapter.DoaDzikirAdapter
import com.thir.doadandzikirapp.databinding.ActivityDzikirPetangBinding
import com.thir.doadandzikirapp.model.DataDoaDzikir

class DzikirPetangActivity : AppCompatActivity() {
    private var _binding: ActivityDzikirPetangBinding? = null
    private val binding get() = _binding as ActivityDzikirPetangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityDzikirPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(DataDoaDzikir.listDzikirPetang())
        binding.rvDzikirPetang.adapter = mAdapter
        binding.rvDzikirPetang.layoutManager = LinearLayoutManager(this)
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