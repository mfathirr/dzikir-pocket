package com.thir.doadandzikirapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thir.doadandzikirapp.databinding.ItemArticleBinding
import com.thir.doadandzikirapp.model.ArticleItem
import com.thir.doadandzikirapp.utils.OnItemCallBack

class ArticleAdapter: RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    private var listArticle = ArrayList<ArticleItem>()
    private var onItemCallBack: OnItemCallBack? = null

    fun setData(list: List<ArticleItem>) {
        listArticle.clear()
        listArticle.addAll(list)
    }

    fun setOnItemClickCallBack(onItemCallBack: OnItemCallBack) {
        this.onItemCallBack = onItemCallBack
    }

    inner class ArticleViewHolder(val view: ItemArticleBinding) : RecyclerView.ViewHolder(view.root )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArticleViewHolder (
        ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = listArticle.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val data = listArticle[position]
        holder.view.itemArticle.setImageResource(data.imageArticle)
        // this will give each item of itemView in viewPager
        holder.itemView.setOnClickListener{
            onItemCallBack?.onItemCLiked(data)
            // proview context for intent
//            it.context.apply {
//                // navigate to DetailActivity
//                val intent = Intent(this, DetailArticleActivity::class.java)
//                // navigate to DetailActivity with datas using putExtra
//                intent.putExtra("title", data.titleArticle)
//                intent.putExtra("content", data.descArticle)
//                intent.putExtra("image", data.imageArticle)
//                startActivity(intent)
//            }
        }
    }

}