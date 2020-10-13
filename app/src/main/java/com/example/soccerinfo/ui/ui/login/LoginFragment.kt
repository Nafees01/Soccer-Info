package com.example.soccerinfo.ui.ui.login

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.ListFragment
import com.example.soccerinfo.R
import com.example.soccerinfo.model.LoginRequestModel
import com.example.soccerinfo.model.LoginResponse
import com.example.soccerinfo.ui.ui.listShow.InfoFragment
import kotlinx.android.synthetic.main.login_fragment.*
import org.jetbrains.anko.sdk27.coroutines.onClick


class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private var loginRequestModel = LoginRequestModel()
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        btn_login.onClick {
            validateData()
        }



        getObserver()
    }

    private fun getObserver() {
        viewModel.loginResponse.observe(viewLifecycleOwner, {
               setLoginResponse(it)
        })
        viewModel.errorResponse.observe(viewLifecycleOwner, {
           showErrorMsg(it)
        })
    }

    private fun showErrorMsg(it: String?) {
       Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
    }

    private fun setLoginResponse(it: LoginResponse) {
         if(it.message=="Successful"){
             if(it.reason.isNullOrEmpty())
             Toast.makeText(context,"Login Successfully!!",Toast.LENGTH_SHORT).show()
             else{
                 Toast.makeText(context,it.reason,Toast.LENGTH_SHORT).show()

             }
            addContentFragment(InfoFragment(),false)
         }
       // else if()
    }

    fun addContentFragment(fragment: androidx.fragment.app.Fragment?, addToBackStack: Boolean) {
        activity?.let {it->
            if (!it.isFinishing) {
                if (fragment == null) {
                    return
                }
                it.supportFragmentManager.let {it1->
                    val fragmentManager =it.supportFragmentManager
                    val currentFragment =
                        fragmentManager.findFragmentById(R.id.layout_home_container)

                    if (currentFragment != null && fragment.javaClass.isAssignableFrom(
                            currentFragment.javaClass
                        )
                    ) {
                        return
                    }

                    val fragmentTransaction = fragmentManager.beginTransaction()

                    fragmentTransaction.add(
                        R.id.layout_home_container,
                        fragment,
                        fragment.javaClass.name
                    )
                    if (addToBackStack) {
                        fragmentTransaction.addToBackStack(fragment.javaClass.name)
                    }

                    fragmentTransaction.commit()



                }
            }
        }
    }
    private fun validateData() {
        if(et_user_name.text.isNullOrEmpty())
            Toast.makeText(context,"User Name is Required",Toast.LENGTH_SHORT).show()
        else if(et_password.text.isNullOrEmpty()){
            Toast.makeText(context,"Password is Required",Toast.LENGTH_SHORT).show()
        }else{
            loginRequestModel.email = et_user_name.text.toString()
            loginRequestModel.password = et_password.text.toString()
            viewModel.requestForLogin(loginRequestModel)
        }
    }

}