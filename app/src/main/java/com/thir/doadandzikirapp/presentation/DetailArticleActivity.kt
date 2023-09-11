package com.thir.doadandzikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thir.doadandzikirapp.databinding.ActivityDetailArticleBinding

class DetailArticleActivity : AppCompatActivity() {
    private var _binding: ActivityDetailArticleBinding? = null
    private val binding get() =  _binding as ActivityDetailArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titleArticle = intent.getStringExtra("title")
        val contentArticle = intent.getStringExtra("content")
        val imageArticle = intent.getIntExtra("image",1)

        binding.apply {
            tvTitleArticle.text = titleArticle
            tvDetailContent.text = contentArticle
            imgDetailArticle.setImageResource(imageArticle)
        }
    }
}