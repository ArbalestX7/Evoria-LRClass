package com.macro4evoria.listenersreaders_class.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.macro4evoria.listenersreaders_class.databinding.ActivityRoleBinding

class RoleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        btnGuru()
        btnMurid()
    }

    private fun btnGuru() {
        binding.ivTeachRole.setOnClickListener {
            startActivity(Intent(this@RoleActivity, LoginActivity::class.java))
        }
    }

    private fun btnMurid() {
        binding.ivStudentRole.setOnClickListener {
            startActivity(Intent(this@RoleActivity, LoginActivity::class.java))
        }
    }
}