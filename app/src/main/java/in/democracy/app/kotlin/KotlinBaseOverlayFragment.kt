package `in`.democracy.app.kotlin

import androidx.annotation.LayoutRes
import `in`.democracy.app.kotlin.KotlinBaseFragment

open class KotlinBaseOverlayFragment(@LayoutRes val layout: Int = 0) : KotlinBaseFragment(layout)