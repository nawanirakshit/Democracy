package `in`.democracy.app.ui.ward

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import `in`.democracy.app.R
import `in`.democracy.app.kotlin.KotlinBaseActivity
import `in`.democracy.app.kotlin.KotlinBaseFragment
import `in`.democracy.app.kotlin.checkBackPressEvent
import `in`.democracy.app.utils.extension.showToast
import `in`.democracy.app.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class WardFragment : KotlinBaseFragment(R.layout.fragment_ward) {

    private val viewModel: MainViewModel by inject()

    private lateinit var mRecycler: RecyclerView
    private val adapter by lazy {
        WardAdapter(
            this::onSelect,
            requireContext()
        )
    }

    private fun onSelect(ward: String) {
        showToast("Selected ward is $ward")
//        replaceFragment<DistrictFragment> {
//            putString(IntentKey.PERM_STATE, state)
//        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        observeViews()
    }

    private fun observeViews() {
        requireView().findViewById<AppCompatImageView>(R.id.button_close).setOnClickListener {
            (activity as KotlinBaseActivity).checkBackPressEvent()
        }
    }

    private fun initViews() {
        mRecycler = requireView().findViewById(R.id.recycler_ward)
        mRecycler.layoutManager = LinearLayoutManager(requireContext())
        mRecycler.adapter = adapter

        for (n in 1 until  40) {
            adapter.addtoList("Ward #$n")
        }

    }
}