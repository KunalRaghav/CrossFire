package com.krsolutions.crossFire

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.TextViewCompat
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {
    lateinit var question: TextView
    lateinit var trueOption: TextView
    lateinit var falseOption: TextView
    lateinit var counter: TextView
    lateinit var loader: ProgressBar
    val questionsBank = QuestionsBank()
    var questionNum = 0
    var correctCounter = 0
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
        question.text = questionsBank.questions[questionNum].question
        counter.text ="${questionNum+1}/${questionsBank.questions.size}"
    }

    val onAnsClickListener = View.OnClickListener {
        trueOption.setOnClickListener(null)
        falseOption.setOnClickListener(null)
        loader.visibility = View.VISIBLE
        when(it.id){
            R.id.trueOption->{
                if(questionsBank.questions[questionNum].isTrue){
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
                if(!questionsBank.questions[questionNum].isTrue){
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

    fun nextQuestion(){
        loader.visibility = View.INVISIBLE
        trueOption.text ="TRUE"
        falseOption.text ="FALSE"
        if(questionNum==questionsBank.questions.size-1){
            quizFinish()
            return
        }
        questionNum++
        question.text = questionsBank.questions[questionNum].question
        counter.text ="${questionNum+1}/${questionsBank.questions.size}"
        trueOption.setOnClickListener(onAnsClickListener)
        falseOption.setOnClickListener(onAnsClickListener)
    }

    fun quizFinish(){
        trueOption.setOnClickListener(onMenuListener)
        falseOption.setOnClickListener(onMenuListener)
        trueOption.text="PLAY AGAIN"
        question.text = "Score: ${correctCounter}"
        falseOption.text="EXIT"
    }

    fun showMessage(bool: Boolean){
        if(bool) {
            trueOption.text = questionsBank.questions[questionNum].errMessage
            falseOption.text=""
        }
        else {
            trueOption.text=""
            falseOption.text = questionsBank.questions[questionNum].errMessage
        }
    }

    fun showCorrect(){
        question.text="Correct ✔"
        correctCounter++
    }

    fun showIncorrect(){
        question.text="Incorrect ❌"
    }

    val onMenuListener = View.OnClickListener {
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