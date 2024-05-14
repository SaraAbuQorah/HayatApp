package com.example.hayatapp.util

import android.view.View
import android.view.View.OnFocusChangeListener
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.example.hayatapp.R
import com.example.hayatapp.data.UserTypeData
import com.google.android.material.imageview.ShapeableImageView


@BindingAdapter("selectedImage")
    fun setSelectedImage(view: ShapeableImageView, isSelected: Boolean) {
        // Set the appropriate image based on the selection state
        view.setImageResource(if (isSelected) R.drawable.group846 else R.drawable.ellipse37)
    }

    @BindingAdapter("selectedBorder")
    fun setSelectedBorder(view: ConstraintLayout, isSelected: Boolean) {
        view.setBackgroundResource(if (isSelected) R.drawable.border_background_gray else 0)
    }

    @BindingAdapter("setItemsName")
    fun setItemsName(
        textView: TextView, item: UserTypeData
    ) {
        item.let {
            textView.text = item.text
        }
    }

    @BindingAdapter("setItemsImage")
    fun setItemsImage(
        img: ImageView, item: UserTypeData
    ) {
        item.let {
            img.setImageResource(item.img)
        }
    }

    @BindingAdapter("selectedOption")
    fun setSelectedOption(view: TextView, isSelected: Boolean) {
        if (isSelected) {
            view.background = ContextCompat.getDrawable(view.context, R.drawable.border_blue)
            view.setTextColor(ContextCompat.getColor(view.context, R.color.blue2))
        } else {
            view.background = null
            view.setTextColor(ContextCompat.getColor(view.context, R.color.gray2))
        }
    }


@BindingAdapter("setItemOnClickArrowBack")
fun setItemOnClickArrowBack(v: View, clickListener: View.OnClickListener?) {
    v.setOnClickListener {
        val navController = v.findNavController()
        navController.popBackStack()
    }

}
@BindingAdapter("hintOnFocus")
fun setHintOnFocus(editText: EditText, hint: String?) {
    editText.setOnFocusChangeListener { v, hasFocus ->
        editText.hint = if (hasFocus) "" else hint
    }
}