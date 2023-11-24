package `in`.democracy.app.ui.blocks

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import `in`.democracy.app.R
import `in`.democracy.app.io.model.ResponseWards
import `in`.democracy.app.kotlin.adapter.BaseAdapter
import `in`.democracy.app.utils.extension.clickWithDebounce

class BlocksAdapter (private val itemClick: (ResponseWards) -> Unit, val context: Context) :
    BaseAdapter<ResponseWards>(R.layout.item_city) {

    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        val data = list[position]

        holder.itemView.findViewById<AppCompatTextView>(R.id.tv_city).text =
            data.block

        holder.itemView.clickWithDebounce {
            itemClick.invoke(list[holder.adapterPosition])
        }
    }
}