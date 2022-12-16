fun main() {

    //    var str = when (a) {
//        in 0..10 -> "маленькое число"
//        in 10..20 -> "большое число"
//        else -> "не могу определить"
//    }

    var secAgo = 1260
    var minutesAgo = secAgo / 60
    var hoursAgo = minutesAgo / 60
//    lateinit var minutes: String
//    lateinit var hours: String
//    var hours = ""

    fun minutesPronounce() =
        when {
            minutesAgo == 1 || minutesAgo % 10 == 1 && minutesAgo != 11 -> "минуту"

//            1, 21, 31, 41, 51 -> "минуту"
//            (minutesAgo == 1 || minutesAgo % 10 == 1) && !(minutesAgo == 11) -> minutes = "минуту" && hours = "час"

//            2, 3, 4 -> "минуты"
//            minutesAgo % 10 == in 2..4 ->  minutes = "минуты" && hours = "часа"
            minutesAgo % 10 in 2..4 && minutesAgo !in 12..14 -> "минуты"


            else -> "минут"
//            else -> "минут"
//            else ->  minutes = "минут" && hours = "часов"
        }

    fun hoursPronounce() =
        when {
            hoursAgo == 1 || hoursAgo % 10 == 1 && hoursAgo != 11 -> "час"
//            minutesAgo == 1 || minutesAgo % 10 == 1 && !(minutesAgo == 11) -> "час"
            hoursAgo % 10 in 2..4 && hoursAgo !in 12..14 -> "часа"
            else -> "часов"
        }

    fun agoToText() = when (secAgo) {
        in 0..60 -> "только что"
        in 61..60 * 60 -> "$minutesAgo ${minutesPronounce()} назад"
        in 60 * 60 + 1..24 * 60 * 60 -> "$hoursAgo ${hoursPronounce()} назад"
        in 24 * 60 * 60 + 1..48 * 60 * 60 -> "вчера"
        in 48 * 60 * 60 + 1..72 * 60 * 60 -> "позавчера"
        else -> "давно"
    }
    println("был(а) ${agoToText()}")

}