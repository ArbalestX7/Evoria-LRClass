package com.macro4evoria.listenersreaders_class.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.macro4evoria.listenersreaders_class.databinding.ActivityJoinKelasBinding

class JoinKelasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJoinKelasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinKelasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnJoin.setOnClickListener {
            kelas()
        }
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun kelas() {
        val i = Intent(this, KelasActivity::class.java)
        i.putExtra("visibility", View.VISIBLE)
        i.putExtra("vis", View.GONE)
        startActivity(i)
    }
}