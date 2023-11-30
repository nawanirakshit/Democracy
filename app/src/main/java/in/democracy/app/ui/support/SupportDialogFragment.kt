package `in`.democracy.app.ui.support

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import `in`.democracy.app.R
import `in`.democracy.app.config.Config
import `in`.democracy.app.utils.RoundedBottomSheetDialogFragment
import `in`.democracy.app.utils.extension.hideKeyboard

class SupportDialogFragment :
    RoundedBottomSheetDialogFragment(R.layout.dialog_support) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hideKeyboard()
        view.findViewById<AppCompatImageView>(R.id.iv_close).setOnClickListener {
            dismissAllowingStateLoss()
        }

        val mPhone: TextView = view.findViewById(R.id.tv_phone)
        val mEmail: TextView = view.findViewById(R.id.tv_email)

        mPhone.text = Config.phone
        mEmail.text = Config.email

        mPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${Config.phone}")
            startActivity(intent)
            dismissAllowingStateLoss()
        }

        mEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${Config.email}")
            }
            startActivity(Intent.createChooser(emailIntent, "Feedback Democracy app"))
            dismissAllowingStateLoss()
        }
    }
}