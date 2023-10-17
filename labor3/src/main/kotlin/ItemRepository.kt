import java.io.BufferedReader
import java.io.File

class ItemRepository {
    private val items: List<Item> = listOf(
        Item("What is Kotlin's primary use case?", listOf("Web development", "Mobile app development", "Game development", "All of the above"), 3),
        Item("In Kotlin, which keyword is used to declare a variable that can be reassigned?", listOf("val", "var", "const", "final"), 1),
        // Add more items here
    )

    fun getAllItems(): List<Item> {
        return items
    }

    // function to read a file line by line and store the questions in a list
fun readQuestionsFromFile(): List<String> {
        val file = File("src/main/resources/questions.txt")
        val bufferedReader: BufferedReader = file.bufferedReader()
        val inputString = bufferedReader.use { it.readText() }
        // split the questions by the index of the correct answer
        val questions = inputString.split("\n*")
        return questions
    }
}