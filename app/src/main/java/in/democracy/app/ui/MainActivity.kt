package `in`.democracy.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import `in`.democracy.app.R
import `in`.democracy.app.kotlin.KotlinBaseActivity
import `in`.democracy.app.kotlin.replaceFragment

class MainActivity : KotlinBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment<StateFragment>()
    }
}