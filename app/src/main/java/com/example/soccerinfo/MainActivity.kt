package com.example.soccerinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.multidex.MultiDexApplication
import com.example.soccerinfo.ui.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentFragment(LoginFragment(),false)
    }

     fun setContentFragment(fragment: androidx.fragment.app.Fragment?, addToBackStack: Boolean) {
        if (!isFinishing) {
            if (fragment == null) {
                return
            }
            supportFragmentManager?.let {
                val fragmentManager = supportFragmentManager
                val currentFragment = fragmentManager.findFragmentById(R.id.layout_home_container)

                if (currentFragment != null && fragment.javaClass.isAssignableFrom(currentFragment.javaClass)) {
                    return
                }

                val fragmentTransaction = fragmentManager.beginTransaction()
//                if (addToBackStack)
//                fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
                fragmentTransaction.replace(R.id.layout_home_container, fragment, fragment.javaClass.name)
                if (addToBackStack) {
                    fragmentTransaction.addToBackStack(fragment.javaClass.name)
                }
                fragmentTransaction.commit()
                fragmentManager.executePendingTransactions()
            }
        }
    }
}