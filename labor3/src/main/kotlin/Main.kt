import java.io.BufferedReader
import java.io.File

fun main(args: Array<String>) {

//    println("Hello, World!")
//    read a txt file line by line and display it's content in the terminal
    val file = File("src/main/resources/questions.txt")
    val bufferedReader: BufferedReader = file.bufferedReader()
    val inputString = bufferedReader.use { it.readText() }
    val itemRepository = ItemRepository()

//    read the file line by line and display it's content and the line number in the terminal
    val lines = inputString.split("\n")
    lines.forEachIndexed { index, line ->
//        println("${index + 1}: $line")
        var question = ""
        var answers = listOf<String>()
        var correct = 0
//        println("$index ${index%6}, $line")
        when (index % 6) {
            0 -> question = line
            1, 2, 3, 4 -> {
                answers = answers.plus(line)
            }
            5 -> {
//                println(line[0].code - 48)
                correct = line[0].code - 48
            }
        }
//        println(question)
        val item = Item(question, answers, correct)
        println(item.question)
        println(item.answers)
//        itemRepository.save(Item(question, answers, correct))
//        println(itemRepository.getItems())
    }

    val itemService = ItemService(itemRepository)
    val itemController = ItemController(itemService)
    itemController.quiz(3)
    println(itemRepository.randomItem())
}