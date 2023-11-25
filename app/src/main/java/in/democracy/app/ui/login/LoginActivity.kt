package `in`.democracy.app.ui.login

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatEditText
import `in`.democracy.app.R
import `in`.democracy.app.kotlin.KotlinBaseActivity
import `in`.democracy.app.kotlin.replaceFragment
import `in`.democracy.app.ui.state.StateFragment
import `in`.democracy.app.ui.status.StatusFragment
import `in`.democracy.app.utils.extension.showToast
import `in`.democracy.app.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class LoginActivity : KotlinBaseActivity() {

    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()

        observeViews()
    }

    private fun observeViews() {
        viewModel.errorMessage.observe(this) {
            hideLoading()
            showToast(it)
        }

        viewModel.successLogin.observe(this) {
            replaceFragment<StatusFragment> {

            }
        }
    }

    private fun initView() {
        val mPassword: AppCompatEditText = findViewById(R.id.password_input_text)
        val mMobile: AppCompatEditText = findViewById(R.id.mobile_input_text)

        findViewById<Button>(R.id.btn_to_dashboard).setOnClickListener {
            val password = mPassword.text.toString()
            val mobile = mMobile.text.toString()

            if (mobile.isBlank()) {
                showToast("mobile is compulsory")
            } else if (password.isBlank()) {
                showToast("Password is compulsory")
            } else {
                viewModel.checkLogin(mobile, password)
            }
        }
    }
}