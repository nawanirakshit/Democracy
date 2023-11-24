package `in`.democracy.app.ui.ward

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import `in`.democracy.app.R
import `in`.democracy.app.io.model.ResponseWards
import `in`.democracy.app.kotlin.adapter.BaseAdapter
import `in`.democracy.app.utils.extension.clickWithDebounce

class WardAdapter (private val itemClick: (ResponseWards) -> Unit, val context: Context) :
    BaseAdapter<ResponseWards>(R.layout.item_ward) {

    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        val data = list[position]

        holder.itemView.findViewById<AppCompatTextView>(R.id.tv_ward).text =
            data.ward

        holder.itemView.clickWithDebounce {
            itemClick.invoke(list[holder.adapterPosition])
        }
    }
}