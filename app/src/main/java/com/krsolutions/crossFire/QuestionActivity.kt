package com.krsolutions.crossFire

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.krsolutions.crossFire.databinding.ActivityQuestionBinding

@SuppressLint("SetTextI18n")
class QuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionBinding

    private val questionsBank = QuestionsBank.getFiveRandomQuestion()
    private var questionNum = 0
    private var correctCounter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.trueOption.setOnClickListener(onAnsClickListener)
        binding.falseOption.setOnClickListener(onAnsClickListener)
        binding.question.text = questionsBank[questionNum].question
        binding.counter.text ="${questionNum+1}/${questionsBank.size}"
    }

    private val onAnsClickListener = View.OnClickListener {
        binding.trueOption.setOnClickListener(null)
        binding.falseOption.setOnClickListener(null)
        binding.loader.visibility = View.VISIBLE
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
        binding.loader.visibility = View.INVISIBLE
        binding.trueOption.text ="TRUE"
        binding.falseOption.text ="FALSE"
        if(questionNum==questionsBank.size-1){
            quizFinish()
            return
        }
        questionNum++
        binding.question.text = questionsBank[questionNum].question
        binding.counter.text ="${questionNum+1}/${questionsBank.size}"
        binding.trueOption.setOnClickListener(onAnsClickListener)
        binding.falseOption.setOnClickListener(onAnsClickListener)
    }

    private fun quizFinish(){
        binding.trueOption.setOnClickListener(onMenuListener)
        binding.falseOption.setOnClickListener(onMenuListener)
        binding.trueOption.text="PLAY AGAIN"
        binding.question.text = "Score: $correctCounter"
        binding.falseOption.text="EXIT"
    }

    private fun showMessage(bool: Boolean){
        if(bool) {
            binding.trueOption.text = questionsBank[questionNum].errMessage
            binding.falseOption.text=""
        }
        else {
            binding.trueOption.text=""
            binding.falseOption.text = questionsBank[questionNum].errMessage
        }
    }

    private fun showCorrect(){
        binding.question.text="Correct ✔"
        correctCounter++
    }

    private fun showIncorrect(){
        binding.question.text="Incorrect ❌"
    }

    private val onMenuListener = View.OnClickListener {
        when(it.id) {
            R.id.trueOption->{
                startActivity(Intent(this, QuestionActivity::class.java))
                finish()
            }
            R.id.falseOption->{
                finish()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val saveQuestionNum = questionNum
        val saveCorrectCounter = correctCounter

        outState.putInt("saveQuestionNum", saveQuestionNum)
        outState.putInt("saveCorrectCounter", saveCorrectCounter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val savedQuestionNum = savedInstanceState.getInt("saveQuestionNum")
        questionNum = savedQuestionNum

        val savedCorrectCounter = savedInstanceState.getInt("saveCorrectCounter")
        correctCounter = savedCorrectCounter

        binding.counter.text ="${questionNum+1}/${questionsBank.size}"
    }
}