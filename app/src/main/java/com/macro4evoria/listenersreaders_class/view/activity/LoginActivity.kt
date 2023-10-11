package com.macro4evoria.listenersreaders_class.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.macro4evoria.listenersreaders_class.R
import com.macro4evoria.listenersreaders_class.databinding.ActivityLoginBinding
import com.macro4evoria.listenersreaders_class.model.User
import com.macro4evoria.listenersreaders_class.view.bottomnavbar.BottomNavigationActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var edtUsername: EditText
    private lateinit var edtPass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        edtUsername = binding.edtLoginUsername
        edtPass = binding.edtLoginPassword
        setUser()

        binding.btnLogin.setOnClickListener { loginCheck() }
        binding.ivGoogle.setOnClickListener { loginwithFbGoogle() }
        binding.ivFb.setOnClickListener { loginwithFbGoogle() }
        binding.btnLoginRegister.setOnClickListener { regis() }
    }

    private fun setUser() {
        val bundle = intent.extras
        if (bundle != null) {
            edtUsername.setText(bundle.getString("username"))
            edtPass.setText(bundle.getString("password"))
        }
    }

    private fun loginCheck() {
        val username = binding.edtLoginUsername.text.toString()
        val password = binding.edtLoginPassword.text.toString()
        val i = Intent(this, BottomNavigationActivity::class.java)

        if (username.isNotEmpty() && password.isNotEmpty()
        ) {
            Snackbar.make(
                window.decorView.rootView,
                getString(R.string.snack_login),
                Snackbar.LENGTH_SHORT
            ).show()

            i.putExtra("User", User(username, password))
            Log.d("loginCheck: ", User(username, password).toString())

            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            finish()
            startActivity(i)
        } else {
            Snackbar.make(
                window.decorView.rootView,
                getString(R.string.snack_login_gagal),
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    private fun loginwithFbGoogle() {
        val i = Intent(this, BottomNavigationActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        finish()
        startActivity(i)
    }

    private fun regis() {
        val i = Intent(this, RegisterActivity::class.java)
        startActivity(i)
    }
}