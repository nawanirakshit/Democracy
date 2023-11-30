package `in`.democracy.app.ui.state

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import `in`.democracy.app.R
import `in`.democracy.app.config.IntentKey
import `in`.democracy.app.config.IntentKey.PERM_COUNTRY
import `in`.democracy.app.config.IntentKey.PERM_STATE
import `in`.democracy.app.io.model.ResponseWards
import `in`.democracy.app.kotlin.KotlinBaseActivity
import `in`.democracy.app.kotlin.KotlinBaseFragment
import `in`.democracy.app.kotlin.checkBackPressEvent
import `in`.democracy.app.kotlin.replaceFragment
import `in`.democracy.app.ui.districts.DistrictFragment
import `in`.democracy.app.ui.support.SupportDialogFragment
import `in`.democracy.app.utils.extension.showDialogFragment
import `in`.democracy.app.utils.extension.showToast
import `in`.democracy.app.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class StateFragment : KotlinBaseFragment(R.layout.fragment_states) {

    private val viewModel: MainViewModel by inject()

    private lateinit var mRecycler: RecyclerView
    private val adapter by lazy {
        StateAdapter(
            this::onSelect, requireContext()
        )
    }

    private fun onSelect(state: ResponseWards) {
        replaceFragment<DistrictFragment> {
            putString(PERM_COUNTRY, arguments?.getString(PERM_COUNTRY))
            putString(PERM_STATE, state.state)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        observeViews()
    }

    private fun observeViews() {
        viewModel.errorMessage.observe(viewLifecycleOwner) {
            hideLoading()
            showToast(it)
        }

        viewModel.successStates.observe(viewLifecycleOwner) {
            hideLoading()
            adapter.addNewList(it)
        }

        requireView().findViewById<AppCompatImageView>(R.id.button_close).setOnClickListener {
            (activity as KotlinBaseActivity).checkBackPressEvent()
        }

    }

    private fun initViews() {
        mRecycler = requireView().findViewById(R.id.recycler_state)
        mRecycler.layoutManager = LinearLayoutManager(requireContext())
        mRecycler.adapter = adapter

        showLoading()
        viewModel.getStates(arguments?.getString(PERM_COUNTRY)!!)
    }
}