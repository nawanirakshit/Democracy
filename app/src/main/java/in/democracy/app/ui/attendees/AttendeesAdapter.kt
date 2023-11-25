package `in`.democracy.app.ui.attendees

import android.content.Context
import android.graphics.Color
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import `in`.democracy.app.R
import `in`.democracy.app.io.model.ResponseWards
import `in`.democracy.app.kotlin.adapter.BaseAdapter
import `in`.democracy.app.utils.extension.clickWithDebounce

class AttendeesAdapter(private val itemClick: (ResponseWards) -> Unit, val context: Context) :
    BaseAdapter<ResponseWards>(R.layout.item_attendees) {

    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        val data = list[position]

        val cardAttendee = holder.itemView.findViewById<CardView>(R.id.card_attendee)
        val attendeeName = holder.itemView.findViewById<AppCompatTextView>(R.id.tv_name)
        val attendeeAddress = holder.itemView.findViewById<AppCompatTextView>(R.id.tv_address)

        val address =
            "${data.ward}, ${data.block}, ${data.state}, ${data.district}, ${data.state}, ${data.country}"

        attendeeAddress.text = address
        attendeeName.text = data.name

        if (data.status == "Present") {
            cardAttendee.setCardBackgroundColor(Color.GREEN);
        } else cardAttendee.setCardBackgroundColor(Color.RED);

        holder.itemView.clickWithDebounce {
            itemClick.invoke(list[holder.adapterPosition])
        }
    }
}