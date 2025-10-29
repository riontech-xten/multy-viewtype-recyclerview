package com.xtensolutions.multyviewtyperecyclerview.ui.binding

import android.graphics.drawable.Icon
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.BindingAdapter

/**
 * Created by Vaghela Mithun R. on 03-01-2025 - 16:38.
 * Email : vaghela.mithun@gmail.com
 * Mob   : +919727206702
 **/

enum class IconPosition {
    START,
    END,
    TOP,
    BOTTOM
}

@BindingAdapter("android:resourceIcon", "android:iconPosition", requireAll = true)
fun bindResourceIcon(textView: TextView, iconResId: Int, iconPosition: IconPosition) {
    val drawable = AppCompatResources.getDrawable(textView.context, iconResId)
    when (iconPosition) {
        IconPosition.START -> textView.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
        IconPosition.END -> textView.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null)
        IconPosition.TOP -> textView.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null)
        IconPosition.BOTTOM -> textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, drawable)
    }
}
