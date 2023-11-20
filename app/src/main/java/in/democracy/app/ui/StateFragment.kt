package `in`.democracy.app.ui

import democracy.app.viewmodel.MainViewModel
import `in`.democracy.app.kotlin.KotlinBaseFragment
import org.koin.android.ext.android.inject

class StateFragment: KotlinBaseFragment() {

    private val viewModel: MainViewModel by inject()
}