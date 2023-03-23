package com.jder00138218.gamescore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), ScoreFragment.OnScorePlusListener{

    private var scoreA = 0
    private var scoreB = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let {
            scoreA = it.getInt(TEAM_A, 0)
            scoreB= it.getInt(TEAM_B, 0)
        }

        val fragmentManager = supportFragmentManager


        val teamAFragment =
            ScoreFragment.newInstance(getString(R.string.team_a_text), scoreA)
        val teamBFragment =
            ScoreFragment.newInstance(getString(R.string.team_b_text), scoreB)

        fragmentManager
            .beginTransaction()
            .replace(R.id.fragment_team_a, teamAFragment)
            .replace(R.id.fragment_team_b, teamBFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(TEAM_A, scoreA)
        outState.putInt(TEAM_B, scoreB)
    }

    companion object {
        const val TEAM_A = "TEAM_A"
        const val TEAM_B = "TEAM_B"
    }

    override fun onPlus(teamName: String, newScore: Int) {
        when (teamName) {
            getString(R.string.team_a_text) -> scoreA = newScore
            getString(R.string.team_b_text) -> scoreB = newScore
        }
    }
}