package `in`.democracy.app.ui.status

import `in`.democracy.app.R
import `in`.democracy.app.kotlin.KotlinBaseFragment
import `in`.democracy.app.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class StatusFragment : KotlinBaseFragment(R.layout.fragment_city) {

    private val viewModel: MainViewModel by inject()
}