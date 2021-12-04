fun main() {
    fun part1(input: List<String>): Int {
        var gamma = ""
        var epsilon = ""

        for (x in 0 until input[0].length) {
            val mostCommonBitZero = input.count { it[x] == '0' } > (input.size / 2)
            if (mostCommonBitZero) {
                gamma += "0"
                epsilon += "1"
            } else {
                gamma += "1"
                epsilon += "0"
            }
        }

        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun part2(input: List<String>): Int {
        val oxygenRating = input.toMutableList()
        for (x in 0 until input[0].length) {
            val zeroes = oxygenRating.count { it[x] == '0' }
            val ones = oxygenRating.count { it[x] == '1' }

            if (zeroes == ones) {
                oxygenRating.removeIf { it[x] == '0' }
            } else if (zeroes > (oxygenRating.size / 2)) {
                oxygenRating.removeIf { it[x] == '1' }
            } else if (ones > (oxygenRating.size / 2)) {
                oxygenRating.removeIf { it[x] == '0' }
            }
        }

        val co2Rating = input.toMutableList()
        for (x in 0 until co2Rating[0].length) {
            val zeroes = co2Rating.count { it[x] == '0' }
            val ones = co2Rating.count { it[x] == '1' }

            if (zeroes == ones) {
                co2Rating.removeIf { it[x] == '1' }
            } else if (zeroes < (co2Rating.size / 2)) {
                co2Rating.removeIf { it[x] == '1' }
            } else if (ones < (co2Rating.size / 2)) {
                co2Rating.removeIf { it[x] == '0' }
            }
        }

        return oxygenRating[0].toInt(2) * co2Rating[0].toInt(2)
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
