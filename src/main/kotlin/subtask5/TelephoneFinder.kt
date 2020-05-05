package subtask5

class TelephoneFinder {

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.toInt()<0){
            return null
        }
        val numbers = arrayListOf<String>()
        for (i in number.indices){
            if (container(number[i]).isNotEmpty()){
                for (j in container(number[i])){
                    numbers.add(number.replaceRange(i,i+1,j.toString()))
                }
            }
        }
        return numbers.toTypedArray()
    }
    private fun container(char: Char):Array<Int> = when(char){
        '1' -> arrayOf(2,4)
        '2' -> arrayOf(1,3,5)
        '3' -> arrayOf(2,6)
        '4' -> arrayOf(1,5,7)
        '5' -> arrayOf(2,4,6,8)
        '6' -> arrayOf(3,5,9)
        '7' -> arrayOf(4,8)
        '8' -> arrayOf(7,5,9,0)
        '9' -> arrayOf(6,8)
        else -> arrayOf(8)
    }
}