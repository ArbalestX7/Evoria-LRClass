package com.macro4evoria.listenersreaders_class.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.macro4evoria.listenersreaders_class.databinding.ActivityEndBinding

class EndActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEndBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEndBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNilai.setOnClickListener {
            startActivity(Intent(this, NilaiActivity::class.java))
        }
    }
}