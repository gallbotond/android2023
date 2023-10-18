class ItemController(private val itemService: ItemService) {
    fun quiz(numQuestions: Int) {
        val randomItems = itemService.selectRandomItems(numQuestions)

        for (item in randomItems) {
            println(item.question)
            for ((index, answer) in item.answers.withIndex()) {
                println("${index + 1} $answer")
            }
            println("Please enter your answer:")
            val userAnswer = readLine()?.toInt()
            if (userAnswer == item.correct) {
                println("You are correct!")
            } else {
                println("You are incorrect!")
            }
        }

    }
}