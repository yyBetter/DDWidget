package com.igetget.www.ddwidget.zhihuadview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.igetget.www.ddwidget.R
import com.igetget.www.ddzhihuadview.ZhihuAdView

/**
 * Created by yangyu on 2017/12/6.
 */
class ZhihuAdViewAdapter(private val context: Context, private var strs: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_NORMAL = 0

    private val TYPE_AD = 1

    var type = TYPE_NORMAL


    override fun getItemCount(): Int {
        return strs.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            6 -> {
                TYPE_AD
            }
            else -> {
                TYPE_NORMAL
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_AD -> {
                val adView = LayoutInflater.from(context).inflate(R.layout.item_zhihu_ad, parent, false)
                AdViewHolder(adView)
            }
            TYPE_NORMAL -> {
                val normalView = LayoutInflater.from(context).inflate(R.layout.item_zhihu_normal, parent, false)
                NormalViewHolder(normalView)
            }
            else -> {
                throw KotlinNullPointerException("type null")
            }
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is AdViewHolder) {

        } else if (holder is NormalViewHolder) {
            holder.tvContent.text = strs[position]
        }
    }

    class AdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivAd: ZhihuAdView = itemView.findViewById(R.id.iv_ad)
    }

    class NormalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvContent: TextView = itemView.findViewById(R.id.tv_content)

    }
}