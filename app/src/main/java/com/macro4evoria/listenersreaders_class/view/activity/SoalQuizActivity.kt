package com.macro4evoria.listenersreaders_class.view.activity

import android.content.Intent
import android.media.SoundPool
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.macro4evoria.listenersreaders_class.R
import com.macro4evoria.listenersreaders_class.databinding.ActivitySoalQuizBinding

class SoalQuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySoalQuizBinding
    private lateinit var sp: SoundPool
    private var soundId: Int = 0
    private var spLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySoalQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        soundPool()
        setBgButton()

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, EndActivity::class.java))
        }

        binding.btnSound.setOnClickListener {
            if (spLoaded) {
                sp.play(soundId, 1f, 1f, 0, 0, 1f)
            }
        }


    }

    private fun soundPool() {
        sp = SoundPool.Builder()
            .setMaxStreams(10)
            .build()

        sp.setOnLoadCompleteListener { _, _, status ->
            if (status == 0) {
                spLoaded = true
            } else {
                Toast.makeText(
                    this@SoalQuizActivity,
                    getString(R.string.load_fail), Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
        soundId = sp.load(this, R.raw.soalmtk, 1)
    }

    private fun setBgButton() {
        binding.apply {
            btnJawabanA.setOnClickListener {
                btnJawabanA.setBackgroundResource(R.drawable.selected_btn_quiz)
                btnJawabanB.setBackgroundResource(R.drawable.default_btn_quiz)
                btnJawabanC.setBackgroundResource(R.drawable.default_btn_quiz)
                btnJawabanD.setBackgroundResource(R.drawable.default_btn_quiz)
            }
            btnJawabanB.setOnClickListener {
                btnJawabanB.setBackgroundResource(R.drawable.selected_btn_quiz)
                btnJawabanA.setBackgroundResource(R.drawable.default_btn_quiz)
                btnJawabanC.setBackgroundResource(R.drawable.default_btn_quiz)
                btnJawabanD.setBackgroundResource(R.drawable.default_btn_quiz)
            }
            btnJawabanC.setOnClickListener {
                btnJawabanC.setBackgroundResource(R.drawable.selected_btn_quiz)
                btnJawabanB.setBackgroundResource(R.drawable.default_btn_quiz)
                btnJawabanA.setBackgroundResource(R.drawable.default_btn_quiz)
                btnJawabanD.setBackgroundResource(R.drawable.default_btn_quiz)
            }
            btnJawabanD.setOnClickListener {
                btnJawabanD.setBackgroundResource(R.drawable.selected_btn_quiz)
                btnJawabanB.setBackgroundResource(R.drawable.default_btn_quiz)
                btnJawabanC.setBackgroundResource(R.drawable.default_btn_quiz)
                btnJawabanA.setBackgroundResource(R.drawable.default_btn_quiz)
            }
        }
    }
}

