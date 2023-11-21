package `in`.democracy.app.ui

import android.os.Bundle
import `in`.democracy.app.R
import `in`.democracy.app.kotlin.KotlinBaseActivity
import `in`.democracy.app.kotlin.addFragment
import `in`.democracy.app.kotlin.replaceFragment
import `in`.democracy.app.ui.state.StateFragment

class MainActivity : KotlinBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment<StateFragment>()

        observeViews()
    }

    private fun observeViews() {

    }
}