package `in`.democracy.app.ui

import android.os.Bundle
import `in`.democracy.app.R
import `in`.democracy.app.kotlin.KotlinBaseActivity
import `in`.democracy.app.kotlin.addFragment
import `in`.democracy.app.kotlin.replaceFragment
import `in`.democracy.app.ui.state.StateFragment
import `in`.democracy.app.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class MainActivity : KotlinBaseActivity() {

    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.init()

        observeViews()
    }

    private fun observeViews() {
        viewModel.successInit.observe(this) {
            addFragment<StateFragment>()
        }
    }
}