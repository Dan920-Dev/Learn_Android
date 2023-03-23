package com.jder00138218.gamescore

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf

private const val TEAM_NAME = "TEAM_NAME"
private const val SCORE = "SCORE"

class ScoreFragment : Fragment() {

    private var teamName = ""
    private var teamScore =  0
    private var scoreListener: OnScorePlusListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnScorePlusListener){
            scoreListener = context
        }else{
            throw Exception("Require a implementation of OnScorePlusListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?. let{
            teamName = it.getString(TEAM_NAME) ?: teamName
            teamScore= it. getInt(SCORE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_score, container, false)

        val teamNameTextView = view.findViewById<TextView>(R.id.team_name_display)
        val teamScoreTextView = view.findViewById<TextView>(R.id.team_score_display)

        teamNameTextView.text = teamName
        teamScoreTextView.text = teamScore.toString()

        val addOnetoScore = view.findViewById<Button>(R.id.add_one_button)

        addOnetoScore.setOnClickListener {
            teamScore++
            teamScoreTextView.text = teamScore.toString()
            scoreListener?.onPlus(teamName, teamScore)
        }
        return view
    }


    companion object {
        @JvmStatic
        fun newInstance(teamName: String, teamScore: Int) =
            ScoreFragment().apply {
                arguments = bundleOf(
                    TEAM_NAME to teamName,
                    SCORE to teamScore
                )
            }
    }

    interface OnScorePlusListener {
        fun onPlus(teamName: String, newScore: Int)
    }
    }


