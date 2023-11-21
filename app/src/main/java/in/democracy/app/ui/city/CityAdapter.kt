package `in`.democracy.app.ui.city

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import `in`.democracy.app.R
import `in`.democracy.app.kotlin.adapter.BaseAdapter
import `in`.democracy.app.utils.extension.clickWithDebounce

class CityAdapter (private val itemClick: (String) -> Unit, val context: Context) :
    BaseAdapter<String>(R.layout.item_city) {

    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        val data = list[position]

        holder.itemView.findViewById<AppCompatTextView>(R.id.tv_city).text =
            data

        holder.itemView.clickWithDebounce {
            itemClick.invoke(list[holder.adapterPosition])
        }
    }
}