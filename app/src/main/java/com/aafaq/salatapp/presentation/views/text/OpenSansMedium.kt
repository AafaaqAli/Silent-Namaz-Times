package com.aafaq.salatapp.presentation.views.text

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.aafaq.salatapp.R


open class OpenSansMedium(context: Context, attributeSet: AttributeSet) : AppCompatTextView(context, attributeSet) {

    init {
        applyFont()
    }

    private fun applyFont() {
        val typeface = ResourcesCompat.getFont(context, R.font.opensans_medium)
        setTypeface(typeface)
    }
}