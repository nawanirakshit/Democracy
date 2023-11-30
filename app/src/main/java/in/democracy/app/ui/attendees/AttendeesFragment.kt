package `in`.democracy.app.ui.attendees

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import `in`.democracy.app.R
import `in`.democracy.app.config.IntentKey
import `in`.democracy.app.config.IntentKey.PERM_ATTENDEE_ID
import `in`.democracy.app.config.IntentKey.PERM_ATTENDEE_STATUS
import `in`.democracy.app.config.IntentKey.PERM_KEY
import `in`.democracy.app.io.model.ResponseWards
import `in`.democracy.app.kotlin.KotlinBaseActivity
import `in`.democracy.app.kotlin.KotlinBaseFragment
import `in`.democracy.app.kotlin.checkBackPressEvent
import `in`.democracy.app.kotlin.replaceFragment
import `in`.democracy.app.ui.attendance.AttendanceFragment
import `in`.democracy.app.ui.login.LoginActivity
import `in`.democracy.app.utils.extension.showToast
import `in`.democracy.app.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class AttendeesFragment : KotlinBaseFragment(R.layout.fragment_attendees) {

    private val viewModel: MainViewModel by inject()

    private lateinit var mRecycler: RecyclerView
    private val adapter by lazy {
        AttendeesAdapter(
            this::onSelect,
            requireContext()
        )
    }

    private fun onSelect(attendee: ResponseWards) {
        if (arguments?.getBoolean(IntentKey.PERM_FROM_LOGIN)!!) {
            replaceFragment<AttendanceFragment> {
                putString(PERM_ATTENDEE_ID, attendee.id)
                putString(PERM_ATTENDEE_STATUS, attendee.status)
            }
        } else {
            val intent = Intent(activity, LoginActivity::class.java)
            val bundle = Bundle()
            bundle.putString(PERM_ATTENDEE_ID, attendee.id)
            bundle.putString(PERM_ATTENDEE_STATUS, attendee.status)
            intent.putExtra(PERM_KEY, bundle)
            startActivity(intent)
        }
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
            arguments?.getString(IntentKey.PERM_BLOCK_ID)!!,
            arguments?.getString(IntentKey.PERM_WARD_ID)!!
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

        viewModel.successAttendees.observe(viewLifecycleOwner) {
            hideLoading()
            adapter.addNewList(it)
        }
    }

    private fun initViews() {
        mRecycler = requireView().findViewById(R.id.recycler_attendees)
        mRecycler.layoutManager = LinearLayoutManager(requireContext())
        mRecycler.adapter = adapter
    }
}