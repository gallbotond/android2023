data class Item(
    val question: String,
    val answers: List<String>,
    val correct: Int
) {
    override fun toString(): String {
        return "Item(question='$question', answers=$answers, correct=$correct)"
    }
}