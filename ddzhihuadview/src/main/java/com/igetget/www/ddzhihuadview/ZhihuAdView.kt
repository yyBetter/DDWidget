package com.igetget.www.ddzhihuadview

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.RectF
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView

/**
 * Created by yangyu on 2017/12/6.
 * adView
 */
class ZhihuAdView : ImageView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    var mBitmapRectF: RectF? = null
    var mBitmap: Bitmap? = null
    var mDy: Int = 0
    var mMinDy: Int? = null


    fun updateY(value: Int) {
        if (drawable == null) {
            return
        }
        if (mMinDy == null) {
            return
        }
        mDy = value!! - mMinDy!!
        if (mDy <= 0) {
            mDy = 0
        }
        if (mDy > mBitmapRectF!!.height() - mMinDy!!) {
            mDy = (mBitmapRectF!!.height() - mMinDy!!).toInt()
        }
        invalidate()
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mMinDy = h
        val imgDrawable = drawable ?: return
        mBitmap = drawable2Bitmap(imgDrawable)
        mBitmapRectF = RectF(0f, 0f, w.toFloat(), (mBitmap!!.height * w / mBitmap!!.width).toFloat())

    }

    private fun drawable2Bitmap(imgDrawable: Drawable): Bitmap? {
        if (imgDrawable is BitmapDrawable) {
            return imgDrawable.bitmap
        }

        val w = imgDrawable.intrinsicWidth
        val h = imgDrawable.intrinsicHeight

        val bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        imgDrawable.setBounds(0, 0, w, h)
        imgDrawable.draw(canvas)
        return bitmap
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (mBitmap == null) {
            return;
        }
        canvas?.save()
        canvas?.translate(0f, (-mDy).toFloat())
        canvas?.drawBitmap(mBitmap, null, mBitmapRectF, null)
        canvas?.restore()


    }

}
