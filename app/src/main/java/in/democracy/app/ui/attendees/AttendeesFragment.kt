package `in`.democracy.app.ui.attendees

import android.content.Intent
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
import `in`.democracy.app.ui.login.LoginActivity
import `in`.democracy.app.utils.extension.showToast
import `in`.democracy.app.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class AttendeesFragment : KotlinBaseFragment(R.layout.fragment_city) {

    private val viewModel: MainViewModel by inject()

    private lateinit var mRecycler: RecyclerView
    private val adapter by lazy {
        AttendeesAdapter(
            this::onSelect,
            requireContext()
        )
    }

    private fun onSelect(attendee: ResponseWards) {
        startActivity(Intent(activity, LoginActivity::class.java))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        observeViews()
    }

    override fun onResume() {
        super.onResume()

        //added here to refresh data if user is logged in
        showLoading()
        viewModel.getAttendees(
            arguments?.getString(IntentKey.PERM_COUNTRY)!!,
            arguments?.getString(IntentKey.PERM_STATE)!!,
            arguments?.getString(IntentKey.PERM_DISTRICT)!!,
            arguments?.getString(IntentKey.PERM_BLOCK)!!,
            arguments?.getString(IntentKey.PERM_WARD)!!
        )


    }

    private fun observeViews() {
        requireView().findViewById<AppCompatImageView>(R.id.button_close).setOnClickListener {
            (activity as KotlinBaseActivity).checkBackPressEvent()
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            hideLoading()
            showToast(it)
        }

        viewModel.successBlock.observe(viewLifecycleOwner) {
            hideLoading()
            adapter.addNewList(it)
        }
    }

    private fun initViews() {
        mRecycler = requireView().findViewById(R.id.recycler_city)
        mRecycler.layoutManager = LinearLayoutManager(requireContext())
        mRecycler.adapter = adapter
    }
}