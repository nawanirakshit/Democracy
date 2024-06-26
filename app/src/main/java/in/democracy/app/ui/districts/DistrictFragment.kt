package `in`.democracy.app.ui.districts

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import `in`.democracy.app.R
import `in`.democracy.app.config.IntentKey
import `in`.democracy.app.io.model.ResponseWards
import `in`.democracy.app.kotlin.KotlinBaseActivity
import `in`.democracy.app.kotlin.KotlinBaseFragment
import `in`.democracy.app.kotlin.checkBackPressEvent
import `in`.democracy.app.kotlin.replaceFragment
import `in`.democracy.app.ui.blocks.BlockFragment
import `in`.democracy.app.utils.extension.showToast
import `in`.democracy.app.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class DistrictFragment : KotlinBaseFragment(R.layout.fragment_district) {

    private val viewModel: MainViewModel by inject()

    private lateinit var mRecycler: RecyclerView
    private val adapter by lazy {
        DistrictAdapter(
            this::onSelect,
            requireContext()
        )
    }

    private fun onSelect(district: ResponseWards) {
        replaceFragment<BlockFragment> {
            putString(IntentKey.PERM_COUNTRY, arguments?.getString(IntentKey.PERM_COUNTRY))
            putString(IntentKey.PERM_DISTRICT, district.district)
            putString(IntentKey.PERM_STATE, arguments?.getString(IntentKey.PERM_STATE))
        }
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

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            hideLoading()
            showToast(it)
        }

        viewModel.successDistrict.observe(viewLifecycleOwner) {
            hideLoading()
            adapter.addNewList(it)
        }
    }

    private fun initViews() {
        mRecycler = requireView().findViewById(R.id.recycler_district)
        mRecycler.layoutManager = LinearLayoutManager(requireContext())
        mRecycler.adapter = adapter

        showLoading()
        viewModel.getDistricts(
            arguments?.getString(IntentKey.PERM_COUNTRY)!!,
            arguments?.getString(IntentKey.PERM_STATE)!!
        )
    }
}