package subtask1

import kotlin.math.abs

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (numbers.isEmpty()) {
            return null
        }
        val string = StringBuilder()
        val count = numbers.size
        for (i in numbers.indices) {
            val num = numbers[i]
            val a = abs(num)
            val powInd = count - i - 1
            if (num != 0) {
                if (num == a) {
                    if (powInd == 0) {
                        string.append(" + ").append(num)
                    } else if (powInd == 1) {
                        if (num == 1) {
                            string.append(" + ").append("x")
                        } else {
                            string.append(" + ").append(num).append("x")
                        }
                    } else {
                        if (num == 1) {
                            string.append(" + ").append("x").append("^").append(powInd)
                        } else {
                            string.append(" + ").append(num).append("x").append("^").append(powInd)
                        }
                    }

                } else {
                    if (powInd == 0) {
                        string.append(" - ").append(a)
                    } else if (powInd == 1) {
                        if (num == -1) {
                            string.append(" - ").append("x")
                        } else {
                            string.append(" - ").append(a).append("x")
                        }
                    } else if (num == -1) {
                        string.append(" - ").append("x").append("^").append(powInd)
                    } else if (num < -1) {
                        string.append(" - ").append(a).append("x").append("^").append(powInd)
                    }

                }
            }
        }
        var s = StringBuilder()
        if (string.startsWith(" + ")) {
            s = string.replace(0, 3, "")
        } else if (string.startsWith(" - ")) {
            s = string.replace(0, 3, "- ")
        }
        return s.toString()
    }
}