package `in`.democracy.app.ui.state

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import `in`.democracy.app.R
import `in`.democracy.app.config.IntentKey.PERM_STATE
import `in`.democracy.app.kotlin.KotlinBaseFragment
import `in`.democracy.app.kotlin.replaceFragment
import `in`.democracy.app.ui.districts.DistrictFragment
import `in`.democracy.app.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class StateFragment : KotlinBaseFragment(R.layout.fragment_states) {

    private val viewModel: MainViewModel by inject()

    private lateinit var mRecycler: RecyclerView
    private val adapter by lazy {
        StateAdapter(
            this::onSelect,
            requireContext()
        )
    }

    private fun onSelect(state: String) {
        replaceFragment<DistrictFragment> {
            putString(PERM_STATE, state)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        observeViews()
    }

    private fun observeViews() {

    }

    private fun initViews() {
        mRecycler = requireView().findViewById(R.id.recycler_state)
        mRecycler.layoutManager = LinearLayoutManager(requireContext())
        mRecycler.adapter = adapter

        for (n in 1 until  36) {
            adapter.addtoList("Uttarakhand $n")
        }

    }
}