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
            "The first oranges weren’t orange",
            true,
            "The original oranges from Southeast Asia were a tangerine-pomelo hybrid, and they were actually green"
        ),
        Question(
            "The Mona Liza was stolen from the Louvre in 1911.",
            true,
            "It was stolen by Vincenzo Peruggia who had worked at the Museum. The masterpiece was recovered two years later."
        ),
        Question(
            "Copyrights depreciate over time.",
            true,
            "Because copyrights have an expiration date, their value decreases as that date approaches."
        ),
        Question(
            "Muddy York is a nickname for New York in the Winter.",
            false,
            "It’s an old nickname given to Toronto, originally called Town of York in honor of The Duke of York. It refers to historical problems in the city’s drainage system."
        ),
        Question(
            "Does Whales make friends for life ?",
            true,
            "They communicate with each other and visit each other. One more proof that animals are not so different from humans."
        ),
        Question(
            "Is the Chinese wall visible from space?",
            false,
            "Contrary to what many people say, from space it is impossible to discern any building. Not even the Great Wall of China."
        ),
        Question(
            "Are penguins in love for life?",
            true,
            "When the penguins find their partner, it is for life. They even propose to each other by giving each other rocks."
        ),
        Question(
            "You only use 10 percent of your brain.",
            false,
            "Modern PET and MRI scans of brain activity show that humans use way more than 10 percent of their gray matter on a regular basis -- though it might seem like some people use way less"
        ),
        Question(
            "One in every 200 men on Earth is descended from Genghis Khan.",
            true,
            "The 13th century Mongolian warrior not only conquered many villages, but also took plenty of lovers. That's 0.5 percent of the male population or 16 million people share Khan's DNA."
        )
    )


    fun getFiveRandomQuestion(): List<Question>{
        questions.shuffle()
        return questions.subList(0,5)
    }


}
