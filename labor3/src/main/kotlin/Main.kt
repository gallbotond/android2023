import java.io.BufferedReader
import java.io.File

fun main(args: Array<String>) {
//    println("Hello, World!")
//    read a txt file line by line and display it's content in the terminal
    val file = File("src/main/resources/questions.txt")
    val bufferedReader: BufferedReader = file.bufferedReader()
    val inputString = bufferedReader.use { it.readText() }
//    println(inputString)

//    store the questions in a list and split them by the empty line between them
    val questions = inputString.split("\n*")

//    display the line number and the question
    for ((index, value) in questions.withIndex()) {
        println("${index + 1} $value")
    }

    val itemRepository = ItemRepository()
//    val itemService = ItemService(itemRepository)
//    val itemController = ItemController(itemService)

    itemRepository.readQuestionsFromFile()
}