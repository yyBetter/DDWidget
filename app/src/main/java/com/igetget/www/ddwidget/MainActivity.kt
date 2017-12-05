package com.igetget.www.ddwidget

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.igetget.www.ddwidget.zhihuadview.ZhihuAdViewActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.tv_zhihu).setOnClickListener {
            val intent = Intent(this, ZhihuAdViewActivity::class.java)
            startActivity(intent)
        }
    }
}
