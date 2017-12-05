package com.igetget.www.ddwidget.zhihuadview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.igetget.www.ddwidget.R
import com.igetget.www.ddzhihuadview.ZhihuAdView

/**
 * Created by yangyu on 2017/12/6.
 * https://juejin.im/post/5a255d94f265da430e4f0066?utm_source=gold_browser_extension
 */
class ZhihuAdViewActivity : AppCompatActivity {

    constructor() : super()

    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zhihu_adview)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter = ZhihuAdViewAdapter(this, mockData())


        recyclerView!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView?.layoutManager

                if (layoutManager is LinearLayoutManager) {
                    val fPos = layoutManager.findFirstVisibleItemPosition()
                    val lPos = layoutManager.findLastCompletelyVisibleItemPosition()
                    for (i in fPos..lPos) {
                        val view = layoutManager.findViewByPosition(i)
                        if (view is ZhihuAdView) {
                            val adIv = view.findViewById<ZhihuAdView>(R.id.iv_ad)
                            adIv.updateY(layoutManager.height - view.top)
                        }
                    }

                }

            }
        })
    }

    private fun mockData(): List<String> {
        return arrayListOf<String>(
                "xixi",
                "hehe",
                "haha",
                "xixi",
                "hehe",
                "haha",
                "xixi",
                "hehe",
                "haha",
                "xixi",
                "hehe",
                "haha"
        )
    }

}