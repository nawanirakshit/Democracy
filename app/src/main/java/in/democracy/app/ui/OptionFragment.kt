package `in`.democracy.app.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import `in`.democracy.app.R
import `in`.democracy.app.kotlin.*
import `in`.democracy.app.ui.country.CountryFragment
import `in`.democracy.app.ui.login.LoginActivity
import `in`.democracy.app.ui.support.SupportDialogFragment
import `in`.democracy.app.utils.extension.showDialogFragment

class OptionFragment : KotlinBaseFragment(R.layout.fragment_option) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<CardView>(R.id.card_login).setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
        }

        view.findViewById<CardView>(R.id.card_search).setOnClickListener {
            replaceFragment<CountryFragment>()
        }

        requireView().findViewById<AppCompatImageView>(R.id.button_close).setOnClickListener {
            (activity as KotlinBaseActivity).checkBackPressEvent()
        }

        val imageViewHelp: AppCompatImageView = requireView().findViewById(R.id.iv_help)
        imageViewHelp.setOnClickListener {
            showDialogFragment<SupportDialogFragment>()
        }
    }
}