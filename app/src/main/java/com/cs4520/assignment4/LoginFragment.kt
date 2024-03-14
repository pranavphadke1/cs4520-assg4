package com.cs4520.assignment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class LoginFragment:Fragment(R.layout.login_view) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.login_view, container, false)
        val loginButton = view.findViewById<View>(R.id.login_button)
        val usernameText = view.findViewById<EditText>(R.id.username_input)
        val passwordText = view.findViewById<EditText>(R.id.password_input)
        val navController = findNavController()
        loginButton.setOnClickListener {
            val username = usernameText.text.toString()
            val password = passwordText.text.toString()

            if (username == "admin" && password == "admin"){
                navController.navigate(R.id.action_loginFragment_to_productListFragment)
                usernameText.setText("")
                passwordText.setText("")

            }
            else {
                Toast.makeText(view.context, "Username or Password is incorrect",Toast.LENGTH_SHORT).show()
            }

        }
        return view
    }
}