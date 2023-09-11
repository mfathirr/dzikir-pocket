package com.thir.doadandzikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.thir.doadandzikirapp.adapter.DoaDzikirAdapter
import com.thir.doadandzikirapp.R
import com.thir.doadandzikirapp.databinding.ActivityDzikirHarianBinding
import com.thir.doadandzikirapp.model.DoaDzikirItem

class DzikirHarianActivity : AppCompatActivity() {
    private var _binding: ActivityDzikirHarianBinding? = null
    private val binding get() = _binding as ActivityDzikirHarianBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_dzikir_harian)
        _binding = ActivityDzikirHarianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        providingDzikirDatas()
        initvView()

    }

    private fun initvView() {
        binding.rvDzikirHarian.apply {
            val mAdapter = DoaDzikirAdapter()
            mAdapter.setData(providingDzikirDatas())
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@DzikirHarianActivity)
        }
    }

    private fun providingDzikirDatas(): List<DoaDzikirItem> {
        val titleDzikir = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val arabicDzikir = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val translateDzikir = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        val listData = arrayListOf<DoaDzikirItem>()
        for (index in titleDzikir.indices) {
            val data = DoaDzikirItem(
                titleDzikir[index],
                arabicDzikir[index],
                translateDzikir[index]
            )
            listData.add(data)
        }
        return listData
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