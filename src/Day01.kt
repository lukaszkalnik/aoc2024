import kotlin.math.abs

fun main() {
    fun parseAndUnzip(input: List<String>): Pair<List<Int>, List<Int>> {
        val idsLineRegex = """(\d+) +(\d+)""".toRegex()

        return input.map {
            val matchGroups = idsLineRegex.matchEntire(it)!!.groupValues
            matchGroups[1].toInt() to matchGroups[2].toInt()
        }.unzip()
    }

    fun part1(input: List<String>): Int {
        val (ids0, ids1) = parseAndUnzip(input)
        val sumOfDiffs = ids0.sorted().zip(ids1.sorted(), Int::minus).sumOf(::abs)
        return sumOfDiffs
    }

    fun part2(input: List<String>): Int {
        val (ids0, ids1) = parseAndUnzip(input)
        val similarity = ids0.toSet().sumOf { id0 -> id0 * ids1.count { it == id0 } * ids0.count { it == id0 } }
        return similarity
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
