fun main() {
    val time = 77432
    println(whenWasOnline(time))
}
fun whenWasOnline(time: Int): String {
    val phrase: String = when (time) {
        in 0..60 -> "был(а) только что" // секунд
        in 61..60 * 60 -> { //минут
            val numeral = time / 60
            val minute = when (numeral) {
                1, 21, 31, 41, 51 -> "минуту"
                in 6..20 -> "минут"
                else -> if (numeral % 10 in 2..4) "минуты" else "минут"
            }
            "был(а) $numeral $minute назад"
        }
        in 60 * 60 + 1..24 * 60 * 60 -> { //часов
            val numeral = (time / 60 / 60)
            val hour = when (numeral) {
                1, 21 -> "час"
                in 5..20 -> "часов"
                else -> "часа"
            }
            "был(а) $numeral $hour назад"
        }
        in 24 * 60 * 60 + 1..2 * 24 * 60 * 60 -> "был(а) вчера"
        in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
    return phrase
}