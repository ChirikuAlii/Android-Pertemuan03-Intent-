package com.chirikualii.pertemuan3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chirikualii.pertemuan3.databinding.ActivityMatchBinding

class MatchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMatchBinding

    var scoreA = 0
    var scoreB = 0

    var teamA = ""
    var teamB = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get value team from intent
        teamA = intent.getStringExtra(Constants.TEAM_A).toString()
        teamB = intent.getStringExtra(Constants.TEAM_B).toString()

        //set value from intent to textview
        binding.tvTeamA.text = teamA
        binding.tvTeamB.text = teamB

        binding.btnTeamAPlus.setOnClickListener { addScoreA() }

        binding.btnTeamAMinus.setOnClickListener { minusScoreA() }

        binding.btnTeamBPlus.setOnClickListener { addScoreB() }

        binding.btnTeamBMinus.setOnClickListener { minusScoreB() }

        binding.btnReset.setOnClickListener { resetScore() }

        binding.btnDone.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(Constants.TEAM_A, teamA)
            intent.putExtra(Constants.TEAM_B, teamB)
            intent.putExtra(Constants.SCORE_A, scoreA)
            intent.putExtra(Constants.SCORE_B, scoreB)


            startActivity(intent)
        }

    }


    private fun addScoreA() {
        scoreA += 1
        binding.tvTeamAScore.text = scoreA.toString()
    }

    private fun minusScoreA() {
        if (scoreA > 0){
            scoreA -= 1
            binding.tvTeamAScore.text = scoreA.toString()
        }
    }

    private fun addScoreB() {
        scoreB += 1
        binding.tvTeamBScore.text = scoreB.toString()
    }

    private fun minusScoreB() {
        if (scoreB > 0){
            scoreB -= 1
            binding.tvTeamBScore.text = scoreB.toString()
        }
    }

    private fun resetScore() {
        scoreB = 0
        scoreA = 0

        binding.tvTeamAScore.text = scoreA.toString()
        binding.tvTeamBScore.text = scoreB.toString()
    }
}