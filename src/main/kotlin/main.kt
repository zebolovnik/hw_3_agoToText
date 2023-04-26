//fun main() {
//
//    println("был(а) ${agoToText()}")
//}
//    var secAgo = 259201
//    var minutesAgo = secAgo / 60
//    var hoursAgo = minutesAgo / 60
//
//    fun minutesPronounce() =
//        when {
//            minutesAgo == 1 || minutesAgo % 10 == 1 && minutesAgo != 11 -> "минуту"
//            minutesAgo % 10 in 2..4 && minutesAgo !in 12..14 -> "минуты"
//            else -> "минут"
//        }
//
//    fun hoursPronounce() =
//        when {
//            hoursAgo == 1 || hoursAgo % 10 == 1 && hoursAgo != 11 -> "час"
//            hoursAgo % 10 in 2..4 && hoursAgo !in 12..14 -> "часа"
//            else -> "часов"
//        }
//
//    fun agoToText() = when (secAgo) {
//        in 0..60 -> "только что"
//        in 61..60 * 60 -> "$minutesAgo ${minutesPronounce()} назад"
//        in 60 * 60 + 1..24 * 60 * 60 -> "$hoursAgo ${hoursPronounce()} назад"
//        in 24 * 60 * 60 + 1..48 * 60 * 60 -> "вчера"
//        in 48 * 60 * 60 + 1..72 * 60 * 60 -> "позавчера"
//        else -> "давно"
//    }
fun main() {
    println("был(а) ${agoToText(259201)}")
}

fun agoToText(secAgo: Int): String {
    val minutesAgo = secAgo / 60
    val hoursAgo = minutesAgo / 60

    fun timePronounce(time: Int, timeName: List<String>) =
        when {
            time == 1 || time % 10 == 1 && time != 11 -> timeName[0]
            time % 10 in 2..4 && time !in 12..14 -> timeName[1]
            else -> timeName[2]
        }

    return when (secAgo) {
        in 0..60 -> "только что"
        in 61..60 * 60 -> "$minutesAgo ${timePronounce(minutesAgo, listOf("минуту", "минуты", "минут"))} назад"
        in 60 * 60 + 1..24 * 60 * 60 -> "$hoursAgo ${timePronounce(hoursAgo, listOf("час", "часа", "часов"))} назад"
        in 24 * 60 * 60 + 1..48 * 60 * 60 -> "вчера"
        in 48 * 60 * 60 + 1..72 * 60 * 60 -> "позавчера"
        else -> "давно"
    }
}
