package com.macro4evoria.listenersreaders_class.view.activity

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.macro4evoria.listenersreaders_class.R
import com.macro4evoria.listenersreaders_class.databinding.ActivityRoleBinding
import com.macro4evoria.listenersreaders_class.view.FirstTimeDialogManager

class RoleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        popUp()
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

    private fun popUp(){
        val dialogManager = FirstTimeDialogManager(this)

        if (dialogManager.shouldShowDialog()) {
            val alertDialog = AlertDialog.Builder(this)
            val tvTitle = layoutInflater.inflate(R.layout.custom_title_dialog,null)
            val customTitle = tvTitle.findViewById<TextView>(R.id.tv_popup_title)

            alertDialog.setCustomTitle(customTitle)
            alertDialog.setMessage(resources.getString(R.string.desc_pop))
            alertDialog.setPositiveButton(resources.getString(R.string.jgn_tampil)) { _, _ ->
                dialogManager.setDialogShown()
            }
            alertDialog.setNegativeButton(resources.getString(R.string.setting)) { _, _ ->
                val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
                startActivity(intent)
            }

            alertDialog.show()
        }
    }
}