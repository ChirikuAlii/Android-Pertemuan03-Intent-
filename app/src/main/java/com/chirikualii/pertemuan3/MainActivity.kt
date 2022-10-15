package com.chirikualii.pertemuan3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chirikualii.pertemuan3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    var teamA = ""
    var teamB = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            //get value from edittext
            teamA = binding.etTeamA.text.toString()
            teamB = binding.etTeamB.text.toString()

            //setup intent
            val intent = Intent(this,MatchActivity::class.java)
            intent.putExtra(Constants.TEAM_A,teamA)
            intent.putExtra(Constants.TEAM_B,teamB)

            startActivity(intent)
        }
    }
}