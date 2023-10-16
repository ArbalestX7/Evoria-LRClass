package com.macro4evoria.listenersreaders_class.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.macro4evoria.listenersreaders_class.databinding.ActivityNilaiBinding
import com.macro4evoria.listenersreaders_class.view.bottomnavbar.BottomNavigationActivity

class NilaiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNilaiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityNilaiBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnClose.setOnClickListener {
            val i = Intent(this, BottomNavigationActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
            finish()
        }
    }
}