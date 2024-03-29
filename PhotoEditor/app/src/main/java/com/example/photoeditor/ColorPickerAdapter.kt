package com.example.photoeditor

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*

class ColorPickerAdapter internal constructor(private var context: Context?, private val colorPickerColors: List<Int>) :
    RecyclerView.Adapter<ColorPickerAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return colorPickerColors.size
    }

    private var inflater: LayoutInflater? = null
    private var onColorPickerClickListener: OnColorPickerClickListener? = null

    init {
        this.inflater = LayoutInflater.from(context)
    }

    internal constructor(context: Context) : this(context, getDefaultColors(context)) {
        this.context = context
        this.inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater!!.inflate(R.layout.color_picker_item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.colorPickerView.setBackgroundColor(colorPickerColors[position])
    }

    /*@Suppress("DEPRECATION")
    private fun buildColorPickerView(view: View, colorCode: Int) {
        view.visibility = View.VISIBLE

        val biggerCircle = ShapeDrawable(OvalShape())
        biggerCircle.intrinsicHeight = 20
        biggerCircle.intrinsicWidth = 20
        biggerCircle.bounds = Rect(0, 0, 20, 20)
        biggerCircle.paint.color = colorCode

        val smallerCircle = ShapeDrawable(OvalShape())
        smallerCircle.intrinsicHeight = 5
        smallerCircle.intrinsicWidth = 5
        smallerCircle.bounds = Rect(0, 0, 5, 5)
        smallerCircle.paint.color = Color.WHITE
        smallerCircle.setPadding(10, 10, 10, 10)
        val drawables = arrayOf<Drawable>(smallerCircle, biggerCircle)

        val layerDrawable = LayerDrawable(drawables)

        view.setBackgroundDrawable(layerDrawable)
    }*/

    fun setOnColorPickerClickListener(onColorPickerClickListener: OnColorPickerClickListener) {
        this.onColorPickerClickListener = onColorPickerClickListener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var colorPickerView: View = itemView.findViewById(R.id.color_picker_view)

        init {
            itemView.setOnClickListener {
                if (onColorPickerClickListener != null)
                    onColorPickerClickListener!!.onColorPickerClickListener(colorPickerColors[adapterPosition])
            }
        }
    }

    interface OnColorPickerClickListener {
        fun onColorPickerClickListener(colorCode: Int)
    }

    companion object {

        fun getDefaultColors(context: Context): List<Int> {
            val colorPickerColors = ArrayList<Int>()
            colorPickerColors.add(ContextCompat.getColor(context, R.color.blue_color_picker))
            colorPickerColors.add(ContextCompat.getColor(context, R.color.brown_color_picker))
            colorPickerColors.add(ContextCompat.getColor(context, R.color.green_color_picker))
            colorPickerColors.add(ContextCompat.getColor(context, R.color.orange_color_picker))
            colorPickerColors.add(ContextCompat.getColor(context, R.color.red_color_picker))
            colorPickerColors.add(ContextCompat.getColor(context, R.color.black))
            colorPickerColors.add(ContextCompat.getColor(context, R.color.red_orange_color_picker))
            colorPickerColors.add(ContextCompat.getColor(context, R.color.sky_blue_color_picker))
            colorPickerColors.add(ContextCompat.getColor(context, R.color.violet_color_picker))
            colorPickerColors.add(ContextCompat.getColor(context, R.color.white))
            colorPickerColors.add(ContextCompat.getColor(context, R.color.yellow_color_picker))
            colorPickerColors.add(ContextCompat.getColor(context, R.color.yellow_green_color_picker))
            return colorPickerColors
        }
    }
}
