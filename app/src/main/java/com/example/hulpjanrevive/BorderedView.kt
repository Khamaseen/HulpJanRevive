package com.example.hulpjanrevive

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet


class BorderedView(
    context: Context,
    attrs: AttributeSet
): androidx.appcompat.widget.AppCompatTextView(context, attrs) {

    private lateinit var template: String

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.BorderedView,
            0, 0).apply {
                try {
                    template = getString(R.styleable.BorderedView_template) ?: "no string set"
                } finally {
                    recycle()
                }
        }

        val face = Typeface.DEFAULT_BOLD
        this.typeface = face
    }

    override fun setText(text: CharSequence?, type: BufferType?) {
        super.setText(text, type)
    }


    fun setTimeRemaining() {
        template = "text to set"
        super.setText(template)
    }

    override fun onDraw(canvas: Canvas) {
        val paint = Paint()
        paint.setColor(Color.RED)
        paint.setStrokeWidth(1.5f)
        paint.setStyle(Paint.Style.STROKE)
        canvas.drawRect(0F, 0F, width.toFloat(), height.toFloat(), paint)
        super.onDraw(canvas)
    }

}