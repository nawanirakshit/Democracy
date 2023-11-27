package `in`.democracy.app.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import `in`.democracy.app.R
import `in`.democracy.app.kotlin.KotlinBaseFragment
import `in`.democracy.app.kotlin.addFragment
import `in`.democracy.app.ui.country.CountryFragment
import `in`.democracy.app.ui.login.LoginActivity
import `in`.democracy.app.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class OptionFragment : KotlinBaseFragment(R.layout.fragment_option) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<CardView>(R.id.card_login).setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
        }

        view.findViewById<CardView>(R.id.card_search).setOnClickListener {
            addFragment<CountryFragment>()
        }
    }
}