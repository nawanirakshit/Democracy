package `in`.democracy.app.ui.city

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import `in`.democracy.app.R
import `in`.democracy.app.config.IntentKey
import `in`.democracy.app.kotlin.KotlinBaseActivity
import `in`.democracy.app.kotlin.KotlinBaseFragment
import `in`.democracy.app.kotlin.checkBackPressEvent
import `in`.democracy.app.kotlin.replaceFragment
import `in`.democracy.app.ui.ward.WardFragment
import `in`.democracy.app.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class CityFragment : KotlinBaseFragment(R.layout.fragment_city) {

    private val viewModel: MainViewModel by inject()

    private lateinit var mRecycler: RecyclerView
    private val adapter by lazy {
        CityAdapter(
            this::onSelect,
            requireContext()
        )
    }

    private fun onSelect(city: String) {
        replaceFragment<WardFragment> {
            putString(IntentKey.PERM_CITY, city)
            putString(IntentKey.PERM_DISTRICT, arguments?.getString(IntentKey.PERM_STATE))
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
    }

    private fun initViews() {
        mRecycler = requireView().findViewById(R.id.recycler_city)
        mRecycler.layoutManager = LinearLayoutManager(requireContext())
        mRecycler.adapter = adapter

        for (n in 1 until  10) {
            adapter.addtoList("Rishikesh $n")
        }

    }
}