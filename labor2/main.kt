import java.io.File

class ListDictionary(filePath: String) : IDictionary {
    private val wordList = mutableListOf<String>()

    init {
        readWordsFromFile(filePath)
    }

    override fun addWord(word: String) {
        wordList.add(word)
    }

    override fun findWord(word: String): Boolean {
        return wordList.contains(word)
    }

    override fun getSize(): Int {
        return wordList.size
    }

    private fun readWordsFromFile(filePath: String) {
        try {
            val file = File(filePath)
            file.forEachLine { line ->
                // Assuming one word per line in the text file
                val word = line.trim()
                if (word.isNotBlank()) {
                    addWord(word)
                }
            }
        } catch (e: Exception) {
            println("Error reading words from file: ${e.message}")
        }
    }
}

fun main() {
    val filePath = "dictionary.txt" // Replace with the path to your text file
    val dictionary: IDictionary = ListDictionary(filePath)

    println("Size of the dictionary: ${dictionary.getSize()}")

    val wordToFind = "banana"
    if (dictionary.findWord(wordToFind)) {
        println("$wordToFind is in the dictionary.")
    } else {
        println("$wordToFind is not in the dictionary.")
    }

    val wordToFind2 = "grape"
    if (dictionary.findWord(wordToFind2)) {
        println("$wordToFind2 is in the dictionary.")
    } else {
        println("$wordToFind2 is not in the dictionary.")
    }
}
