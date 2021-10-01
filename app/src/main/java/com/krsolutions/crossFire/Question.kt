package com.krsolutions.crossFire

import java.util.*
import kotlin.collections.ArrayList

data class Question(
    val question: String,
    val isTrue: Boolean,
    val errMessage: String
)

object QuestionsBank {
    private val questions: ArrayList<Question> = arrayListOf(
        Question(
            "Other than water, coffee is the world's most popular drink.",
            true,
            "Coffee is consumed by about one-third of Earth's population."
        ),
        Question(
            "Approximately one quarter of human bones are in the feet",
            true,
            "True – 52 bones in the feet and 206 in the whole body."
        ),
        Question(
            "The average person will shed 10 pounds of skin during their lifetime.",
            false,
            "False – they will shed approximately 40"
        ),
        Question(
            "The Great Wall Of China is visible from the moon.",
            false,
            "False – at a low orbit the Great Wall is visible, but no man-made structure is visible from outer space or the moon."
        ),
        Question(
            "Louis Braille, creator of the Braille system of writing for the blind, was himself blind.",
            true,
            "Despite being blinded at an early age, Braille was an accomplished musician, inventor, and teacher of the blind."
        ),
        Question(
            "Peanuts are not nuts.",
            true,
            "Peanuts are legumes like lentils and peas."
        ),
        Question(
            "People may sneeze or cough while sleeping deeply.",
            false,
            "We can’t sneeze or cough when in deep sleep. Our body must enter a state of wakefulness to do so."
        ),
        Question(
            "The Mona Liza was stolen from the Louvre in 1911.",
            true,
            "It was stolen by Vincenzo Peruggia who had worked at the Museum. The masterpiece was recovered two years later."
        )
    )


    fun getFiveRandomQuestion(): List<Question>{
        questions.shuffle()
        return questions.subList(0,5);
    }


}