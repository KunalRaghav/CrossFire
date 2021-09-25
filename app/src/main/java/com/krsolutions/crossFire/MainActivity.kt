package com.krsolutions.crossFire

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("SetTextI18n")
class MainActivity : AppCompatActivity() {
    private lateinit var question: TextView
    private lateinit var trueOption: TextView
    private lateinit var falseOption: TextView
    private lateinit var counter: TextView
    private lateinit var loader: ProgressBar
    private val questionsBank = QuestionsBank.getFiveRandomQuestion()
    private var questionNum = 0
    private var correctCounter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        question = findViewById(R.id.question)
        trueOption = findViewById(R.id.trueOption)
        falseOption = findViewById(R.id.falseOption)
        counter = findViewById(R.id.counter)
        loader = findViewById(R.id.loader)
        trueOption.setOnClickListener(onAnsClickListener)
        falseOption.setOnClickListener(onAnsClickListener)
        question.text = questionsBank[questionNum].question
        counter.text ="${questionNum+1}/${questionsBank.size}"
    }

    private val onAnsClickListener = View.OnClickListener {
        trueOption.setOnClickListener(null)
        falseOption.setOnClickListener(null)
        loader.visibility = View.VISIBLE
        when(it.id){
            R.id.trueOption->{
                if(questionsBank[questionNum].isTrue){
                    showMessage(true)
                    showCorrect()
                }else{
                    showMessage(false)
                    showIncorrect()
                }
                Handler(Looper.getMainLooper()).postDelayed({
                    nextQuestion()
                },2000)
            }
            R.id.falseOption->{
                if(!questionsBank[questionNum].isTrue){
                    showMessage(false)
                    showCorrect()
                }else{
                    showMessage(true)
                    showIncorrect()
                }
                Handler(Looper.getMainLooper()).postDelayed({
                    nextQuestion()
                },3000)
            }
        }
    }

    private fun nextQuestion(){
        loader.visibility = View.INVISIBLE
        trueOption.text ="TRUE"
        falseOption.text ="FALSE"
        if(questionNum==questionsBank.size-1){
            quizFinish()
            return
        }
        questionNum++
        question.text = questionsBank[questionNum].question
        counter.text ="${questionNum+1}/${questionsBank.size}"
        trueOption.setOnClickListener(onAnsClickListener)
        falseOption.setOnClickListener(onAnsClickListener)
    }

    private fun quizFinish(){
        trueOption.setOnClickListener(onMenuListener)
        falseOption.setOnClickListener(onMenuListener)
        trueOption.text="PLAY AGAIN"
        question.text = "Score: $correctCounter"
        falseOption.text="EXIT"
    }

    private fun showMessage(bool: Boolean){
        if(bool) {
            trueOption.text = questionsBank[questionNum].errMessage
            falseOption.text=""
        }
        else {
            trueOption.text=""
            falseOption.text = questionsBank[questionNum].errMessage
        }
    }

    private fun showCorrect(){
        question.text="Correct ✔"
        correctCounter++
    }

    private fun showIncorrect(){
        question.text="Incorrect ❌"
    }

    private val onMenuListener = View.OnClickListener {
        when(it.id) {
            R.id.trueOption->{
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            R.id.falseOption->{
                finish()
            }
        }
    }
}