package com.krsolutions.crossFire

data class Question(
        val question: String,
        val isTrue: Boolean,
        val errMessage: String
)

class QuestionsBank {
    val questions: ArrayList<Question> = ArrayList()

    init {
        questions.add(Question("Other than water, coffee is the world's most popular drink.", true, "Coffee is consumed by about one-third of Earth's population."))
        questions.add(Question("Approximately one quarter of human bones are in the feet", true, "True – 52 bones in the feet and 206 in the whole body."))
        questions.add(Question("The average person will shed 10 pounds of skin during their lifetime.", false, "False – they will shed approximately 40"))
        questions.add(Question("The Great Wall Of China is visible from the moon.", false, "False – at a low orbit the Great Wall is visible, but no man-made structure is visible from outer space or the moon."))
        questions.add(Question("Louis Braille, creator of the Braille system of writing for the blind, was himself blind.", true, "Despite being blinded at an early age, Braille was an accomplished musician, inventor, and teacher of the blind."))
    }
}