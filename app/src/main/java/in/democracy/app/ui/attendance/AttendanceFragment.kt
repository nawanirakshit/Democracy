package `in`.democracy.app.ui.attendance

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import `in`.democracy.app.R
import `in`.democracy.app.config.IntentKey
import `in`.democracy.app.kotlin.KotlinBaseActivity
import `in`.democracy.app.kotlin.KotlinBaseFragment
import `in`.democracy.app.kotlin.checkBackPressEvent
import `in`.democracy.app.utils.extension.showToast
import `in`.democracy.app.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class AttendanceFragment : KotlinBaseFragment(R.layout.fragment_attendance) {

    private val viewModel: MainViewModel by inject()

    var selectedAttendanceType = "Present"

    private val radioGroup: RadioGroup by lazy { requireView().findViewById(R.id.rg_attendance) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        observeViews()
    }

    private fun initViews() {

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            // on below line we are getting radio button from our group.
            val radioButton = requireView().findViewById<RadioButton>(checkedId)
            selectedAttendanceType = radioButton.text.toString()
        }

        requireView().findViewById<AppCompatButton>(R.id.btn_mark_attendance).setOnClickListener {
            showLoading()
            viewModel.markAttendance(
                arguments?.getString(IntentKey.PERM_ATTENDEE_ID)!!,
                selectedAttendanceType
            )
        }
    }

    private fun observeViews() {
        requireView().findViewById<AppCompatImageView>(R.id.button_close).setOnClickListener {
            (activity as KotlinBaseActivity).checkBackPressEvent()
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            hideLoading()
            showToast(it)
        }

        viewModel.successAttendance.observe(viewLifecycleOwner) {
            hideLoading()
            (activity as KotlinBaseActivity).checkBackPressEvent()
        }
    }
}