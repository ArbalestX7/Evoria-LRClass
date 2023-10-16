package com.macro4evoria.listenersreaders_class.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.macro4evoria.listenersreaders_class.R
import com.macro4evoria.listenersreaders_class.databinding.ActivityPanduanBinding

class PanduanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPanduanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPanduanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        binding.btnGuru.setOnClickListener {
            setViewGuru()
        }
        binding.btnSiswa.setOnClickListener {
            setViewSiswa()
        }
    }

    private fun setViewGuru() {
        binding.apply {
            btnGuru.setBackgroundResource(R.drawable.btn_panduan)
            btnSiswa.setBackgroundResource(R.drawable.btn_siswa_dis)

            tvKelasGuru.visibility = View.VISIBLE
            tvIsiKelas.visibility = View.VISIBLE
            tvMateriGuru.visibility = View.VISIBLE
            tvIsiMateri.visibility = View.VISIBLE
            tvQuizGuru.visibility = View.VISIBLE
            tvQuizMateri.visibility = View.VISIBLE

            tvKelasSiswa.visibility = View.GONE
            tvIsiKelasSiswa.visibility = View.GONE
            tvMateriSiswa.visibility = View.GONE
            tvIsiMateriSiswa.visibility = View.GONE
            tvQuizSiswa.visibility = View.GONE
            tvQuizMateriSiswa.visibility = View.GONE
            tvExplorSiswa.visibility = View.GONE
            tvExplorMateriSiswa.visibility = View.GONE
        }
    }

    private fun setViewSiswa() {
        binding.apply {
            btnGuru.setBackgroundResource(R.drawable.btn_panduan_dis)
            btnSiswa.setBackgroundResource(R.drawable.btn_siswa)

            tvKelasGuru.visibility = View.GONE
            tvIsiKelas.visibility = View.GONE
            tvMateriGuru.visibility = View.GONE
            tvIsiMateri.visibility = View.GONE
            tvQuizGuru.visibility = View.GONE
            tvQuizMateri.visibility = View.GONE

            tvKelasSiswa.visibility = View.VISIBLE
            tvIsiKelasSiswa.visibility = View.VISIBLE
            tvMateriSiswa.visibility = View.VISIBLE
            tvIsiMateriSiswa.visibility = View.VISIBLE
            tvQuizSiswa.visibility = View.VISIBLE
            tvQuizMateriSiswa.visibility = View.VISIBLE
            tvExplorSiswa.visibility = View.VISIBLE
            tvExplorMateriSiswa.visibility = View.VISIBLE
        }
    }
}