package subtask3

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val filteredArray = itemsFromArray.filterIsInstance<Int>()

        if (filteredArray.isNotEmpty()) {
            var result = 1
            if (numberOfItems >= filteredArray.size) {
                for (i in filteredArray) {
                    result *= i
                }
                return result
            } else {
                val posArray = filteredArray.filter { p -> p > 0 }.sorted().reversed()
                val negArray = filteredArray.filter { p -> p < 0 }.sorted()
                var countOfNeg = negArray.size

                var pVal = 1
                var nVal = 1

                if (negArray.isNotEmpty()) {
                    var count = numberOfItems
                    if (numberOfItems >= negArray.size) {
                        while (countOfNeg > 0) {
                            if (countOfNeg % 2 == 0) {
                                for (i in 0 until countOfNeg) {
                                    nVal *= negArray[i]
                                    count--
                                }
                            }
                            countOfNeg--
                        }
                    }
                    var count1 = numberOfItems
                    while (count1 > 0) {
                        for (i in 0 until count1) {
                            pVal *= posArray[i]
                            count1--
                        }

                    }
                    while (count > 0) {
                        for (i in 0 until count) {
                            nVal *= posArray[i]
                            count--
                        }
                    }

                } else {
                    if (numberOfItems >= posArray.size) {
                        for (i in posArray) {
                            result *= i
                        }
                    }
                }

                return if (pVal > nVal) pVal else nVal
            }
        }
        return 0
    }
}
