class ItemService(private val itemRepository: ItemRepository) {
    fun selectRandomItems(numQuestions: Int): List<Item> {
        val allItems = itemRepository.getItems()
        val shuffledItems = allItems.shuffled()
        return shuffledItems.take(numQuestions)
    }
}