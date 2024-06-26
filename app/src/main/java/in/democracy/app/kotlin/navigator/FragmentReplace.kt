package `in`.democracy.app.kotlin.navigator

import androidx.annotation.Keep
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

@Keep
class FragmentReplace(val container: Int) : FragmentBehaviour() {
    var containerId: Int = container
    override fun execute(transaction: FragmentTransaction, fragment: Fragment, tag: String?) {
        transaction.replace(containerId, fragment, tag)
    }

    override fun setContainer(container: Int) {
        containerId = container.run { if (this == 0) this@FragmentReplace.container else this }
    }

}