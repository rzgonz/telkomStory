package com.telkom.topstories.ext

import android.os.Bundle
import androidx.annotation.AnimRes
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.telkom.common.tag

inline fun <reified T : Fragment> FragmentActivity?.replaceFragment(
    @IdRes containerViewId: Int,
    @AnimRes enterAnimation: Int = 0,
    @AnimRes exitAnimation: Int = 0,
    data: Bundle = Bundle(),
    isAddToBackStack: Boolean = false
) {
    this?.supportFragmentManager?.beginTransaction()?.run {
        setCustomAnimations(enterAnimation, exitAnimation)
        replace(containerViewId, T::class.java.getConstructor().newInstance().apply {
            arguments = data
        } as T)
        if (isAddToBackStack) {
            addToBackStack(tag<T>())
        }
        return@run commit()
    }
}

inline fun <reified T : Fragment> FragmentActivity?.addFragment(
    @IdRes containerViewId: Int,
    @AnimRes enterAnimation: Int = 0,
    @AnimRes exitAnimation: Int = 0,
    data: Bundle = Bundle(),
    isAddToBackStack: Boolean = false
) {
    this?.supportFragmentManager?.beginTransaction()?.run {
        setCustomAnimations(enterAnimation, exitAnimation)
        add(containerViewId, T::class.java.getConstructor().newInstance().apply {
            arguments = data
        } as T)
        if (isAddToBackStack) {
            addToBackStack(tag<T>())
        }
        return@run commit()
    }
}