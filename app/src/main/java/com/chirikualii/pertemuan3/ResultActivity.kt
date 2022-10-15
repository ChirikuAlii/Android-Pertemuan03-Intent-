package com.chirikualii.pertemuan3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chirikualii.pertemuan3.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding : ActivityResultBinding

    var resultA = ""
    var resultB = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get value from intent
        val teamA = intent.getStringExtra(Constants.TEAM_A).toString()
        val teamB = intent.getStringExtra(Constants.TEAM_B).toString()
        val scoreA = intent.getIntExtra(Constants.SCORE_A,0)
        val scoreB = intent.getIntExtra(Constants.SCORE_B,0)

        resultA = "$teamA : $scoreA"
        resultB = "$teamB : $scoreB"

        //set value to textview
        binding.tvResultA.text = resultA
        binding.tvResultB.text = resultB

    }
}