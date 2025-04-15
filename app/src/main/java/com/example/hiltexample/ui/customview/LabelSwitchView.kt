package com.example.hiltexample.ui.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.hiltexample.databinding.ViewLabelSwitchBinding

class LabelSwitchView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): FrameLayout(context, attrs, defStyleAttr) {

    private val binding: ViewLabelSwitchBinding

    init {
         val inflater = LayoutInflater.from(context)
        binding = ViewLabelSwitchBinding.inflate(inflater, this)
    }

    fun setLabel(label: String) {
        binding.lableText.text = label
    }

    fun setSwitchChecked(isChecked: Boolean) {
        binding.toggleSwitch.isChecked = isChecked
    }

    fun isSwitchChecked(): Boolean {
        return binding.toggleSwitch.isChecked
    }

    fun setOnSwitchCheckedChangeListener(listener: (Boolean) -> Unit) {
        binding.toggleSwitch.setOnCheckedChangeListener { _, isChecked ->
            listener(isChecked)
        }
    }
}