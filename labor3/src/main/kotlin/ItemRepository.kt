import java.io.BufferedReader
import java.io.File

class ItemRepository {
    private var items: List<Item> = listOf()

//    val getItems: List<Item>
//        get() = items

    fun save(item: Item) {
        items = items.plus(item)
    }

    fun getItems(): List<Item> {
        return items
    }

    fun randomItem(): Item {
        val randomIndex = (0..items.size).random()
        return items[randomIndex]
    }
}