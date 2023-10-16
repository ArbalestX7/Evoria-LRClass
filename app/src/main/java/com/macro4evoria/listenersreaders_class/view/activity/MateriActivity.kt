package com.macro4evoria.listenersreaders_class.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.macro4evoria.listenersreaders_class.databinding.ActivityMateriBinding

class MateriActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMateriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMateriBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setMateriKim()
        setMateriMTK()

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setMateriMTK() {
        val mtk = intent.getIntExtra(MATERI_MTK, View.GONE)
        binding.apply {
            ivMtkBaris.visibility = mtk
            ivMtkFungsi.visibility = mtk
            ivMtkLingkaran.visibility = mtk
            ivMtkMatrix.visibility = mtk
        }
    }

    /*private fun setMateriBio() {
        val bio = intent.getIntExtra(PelajaranActivity.EXTRA_BIO, View.GONE)
        binding.ivPelajaranBio.visibility = bio
    }*/

    /*private fun setMateriKim() {
        val kim = intent.getIntExtra(MATERI_KIM, View.VISIBLE)
        Log.d("setMateriKim: ", kim.toString())
        binding.apply {
            ivKimAsam.visibility = kim
            ivKimGaram.visibility = kim
            ivKimHidro.visibility = kim
            ivKimKoloid.visibility = kim
        }
    }*/

    companion object{
        const val MATERI_MTK = "materi_mtk"
        const val MATERI_KIM = "materi_kim"
        const val MATERI_BIO = "materi_bio"
    }
}