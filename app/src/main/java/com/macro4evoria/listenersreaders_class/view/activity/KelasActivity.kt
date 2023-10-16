package com.macro4evoria.listenersreaders_class.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.macro4evoria.listenersreaders_class.databinding.ActivityKelasBinding

class KelasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKelasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKelasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setKelas()

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        binding.fabAddKelas.setOnClickListener {
            joinKelas()
        }
        binding.apply {
            ivKlsMtk.setOnClickListener { masukKelasMTK() }
            ivKlsKimia.setOnClickListener { masukKelasKim() }
            ivKlsBio.setOnClickListener { masukKelasBio() }
        }
    }

    private fun joinKelas() {
        startActivity(Intent(this@KelasActivity, JoinKelasActivity::class.java))
    }

    private fun setKelas() {
        val visibility = intent.getIntExtra("visibility", View.GONE)
        val vis = intent.getIntExtra("vis", View.VISIBLE)
        binding.apply {
            ivKelasBlank.visibility = vis
            tvKelasBlank.visibility = vis

            ivKlsMtk.visibility = visibility
            ivKlsBio.visibility = visibility
            ivKlsKimia.visibility = visibility
        }
        Log.d("setKelas: ", vis.toString())
        Log.d("setKelas: ", visibility.toString())

    }

    private fun masukKelasMTK() {
        val i = Intent(this, PelajaranActivity::class.java)
        i.putExtra(PelajaranActivity.EXTRA_MTK, View.VISIBLE)
        startActivity(i)
    }

    private fun masukKelasBio() {
        val i = Intent(this, PelajaranActivity::class.java)
        i.putExtra(PelajaranActivity.EXTRA_BIO, View.VISIBLE)
        startActivity(i)
    }

    private fun masukKelasKim() {
        val i = Intent(this, PelajaranActivity::class.java)
        i.putExtra(PelajaranActivity.EXTRA_KIM, View.VISIBLE)
        startActivity(i)
    }
}