package com.macro4evoria.listenersreaders_class.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.macro4evoria.listenersreaders_class.databinding.ActivityPelajaranBinding

class PelajaranActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPelajaranBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPelajaranBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setPelajaranMTK()
        setPelajaranBio()
        setPelajaranKim()

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
        binding.ivMateri.setOnClickListener {
            startActivity(Intent(this, MateriActivity::class.java))
        }
        binding.ivQuiz.setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
        }
    }

    private fun setPelajaranMTK() {
        val mtk = intent.getIntExtra(EXTRA_MTK, View.GONE)
        binding.ivPelajaranMtk.visibility = mtk
    }

    private fun setPelajaranBio() {
        val bio = intent.getIntExtra(EXTRA_BIO, View.GONE)
        binding.ivPelajaranBio.visibility = bio
    }

    private fun setPelajaranKim() {
        val kim = intent.getIntExtra(EXTRA_KIM, View.GONE)
        binding.ivPelajaranKimia.visibility = kim
    }

    companion object {
        const val EXTRA_MTK = "extra_mtk"
        const val EXTRA_KIM = "extra_kim"
        const val EXTRA_BIO = "extra_bio"
    }
}