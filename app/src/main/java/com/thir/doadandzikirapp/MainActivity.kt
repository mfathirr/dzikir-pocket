package com.thir.doadandzikirapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.card.MaterialCardView
import com.thir.doadandzikirapp.adapter.ArticleAdapter
import com.thir.doadandzikirapp.databinding.ActivityMainBinding
import com.thir.doadandzikirapp.model.ArticleItem
import com.thir.doadandzikirapp.presentation.DetailArticleActivity
import com.thir.doadandzikirapp.presentation.DzikirHarianActivity
import com.thir.doadandzikirapp.presentation.DzikirSetiapSaatActivity
import com.thir.doadandzikirapp.presentation.pagipetang.PagiPetangActivity
import com.thir.doadandzikirapp.presentation.QauliyahShalatActivity
import com.thir.doadandzikirapp.utils.OnItemCallBack

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private var dotSliderIndicator = arrayOf<ImageView?>()

    // OnPageCallBack is SubClass from ViewPage2 for
    // responding to changing state of the selected page
    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        // instance onPageSelected give you access to setting behavior state of selected page
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            for (i in initData().indices) {
                dotSliderIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.inactive_dot)
                )
            }

            dotSliderIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.active_dot)
            )

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // this method is from dependencies Splash Screen API 12
        installSplashScreen()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // declare variable to get in touch with view item in layout
        // use findViewById to communicate with the view
        val cardQauliyahShalat = findViewById<MaterialCardView>(R.id.card_qauliyah_shalat)
        val cardDzikir = findViewById<MaterialCardView>(R.id.card_dzikir_harian)
        val cardDzikirHarian = findViewById<MaterialCardView>(R.id.card_dzikir_setiap_hari)
        val cardDzikirPagiPetang = findViewById<MaterialCardView>(R.id.card_dzikir_pagi_petang)

        // when cardview cliked it will be direct to next page
        // Intent is use for navigate to other activity by clikcing
        cardQauliyahShalat.setOnClickListener {
            val intent = Intent(this, QauliyahShalatActivity::class.java)
            startActivity(intent)
        }

        cardDzikir.setOnClickListener(this)
        cardDzikirHarian.setOnClickListener(this)
        cardDzikirPagiPetang.setOnClickListener(this)

        val mAdapter = ArticleAdapter()
        mAdapter.setData(initData())
        mAdapter.setOnItemClickCallBack(object : OnItemCallBack {
            override fun onItemCLiked(Item: ArticleItem) {
                // navigate to DetailActivity
                val intent = Intent(this@MainActivity, DetailArticleActivity::class.java)
                // navigate to DetailActivity with datas using putExtra
                intent.putExtra("title", Item.titleArticle)
                intent.putExtra("content", Item.descArticle)
                intent.putExtra("image", Item.imageArticle)
                startActivity(intent)
            }

        })
        binding.vpArticle.adapter = mAdapter
        binding.vpArticle.registerOnPageChangeCallback(slidingCallback)

        setUpViewPager()
    }

    private fun setUpViewPager() {
        dotSliderIndicator = arrayOfNulls(initData().size)

        for (i in initData().indices) {
            dotSliderIndicator[i] = ImageView(this)
            dotSliderIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.inactive_dot)
            )
            val params = LinearLayoutCompat.LayoutParams(35, 35)
            params.marginStart = 8
            params.marginEnd = 8
            binding.dots.addView(dotSliderIndicator[i], params)
        }
    }


    private fun initData(): List<ArticleItem> {
        val titleArticle = resources.getStringArray(R.array.arr_title_artikel)
        val contentArticle = resources.getStringArray(R.array.arr_desc_artikel)
        val imageArticle = resources.obtainTypedArray(R.array.arr_img_artikel)
        val listData = arrayListOf<ArticleItem>()
        for (i in titleArticle.indices) {
            val data = ArticleItem(
                titleArticle[i],
                imageArticle.getResourceId(i, 0),
                contentArticle[i]
            )
            listData.add(data)
        }
        imageArticle.recycle()
        return listData
    }

    override fun onClick(view: View) {
        when (view?.id) {
            R.id.card_dzikir_setiap_hari -> startActivity(
                Intent(
                    this,
                    DzikirSetiapSaatActivity::class.java
                )
            )

            R.id.card_dzikir_harian -> startActivity(Intent(this, DzikirHarianActivity::class.java))
            R.id.card_dzikir_pagi_petang -> startActivity(
                Intent(
                    this,
                    PagiPetangActivity::class.java
                )
            )
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}