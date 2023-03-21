package com.aafaq.salatapp.presentation.views.text

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.aafaq.salatapp.R


open class OpenSansBold(context: Context, attributeSet: AttributeSet) : AppCompatTextView(context, attributeSet) {

    init {
        applyFont()
        setHeadingAttributes()
    }

    private fun applyFont() {
        val typeface = ResourcesCompat.getFont(context, R.font.opensans_bold)
        setTypeface(typeface)
    }

    private fun setHeadingAttributes(){
        this.setTextColor(resources.getColor(R.color.black))
        this.textSize = resources.getDimension(com.intuit.ssp.R.dimen._6ssp)

    }
}