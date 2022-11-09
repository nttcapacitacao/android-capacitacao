package com.briapps.core.base

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment(
    @LayoutRes private val layoutActivityId: Int = 0,
    private val injectDependencies: Boolean = false
) : Fragment(layoutActivityId) {

    /*protected var userIsLogged: Boolean = false
    protected var userName: String? = ""*/

    /*private lateinit var firebaseAuth: FirebaseAuth
    private var firebaseUser: FirebaseUser? = null*/

    override fun onAttach(context: Context) {

        /*firebaseAuth = FirebaseAuth.getInstance()
        firebaseUser = firebaseAuth.currentUser
        firebaseUser?.let { firebaseUser ->
            userName = firebaseUser.displayName.takeIf { it?.isEmpty() == true }
                ?.let { firebaseUser.email }
            userIsLogged = true
        }*/

        if (injectDependencies) {
            AndroidSupportInjection.inject(this)
        }
        super.onAttach(context)
    }
}