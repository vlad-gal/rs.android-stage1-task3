package subtask2

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        val numOfPosters:Long = array[0].toLong()
        val numOfColors:Long = array[1].toLong()
        for (i in 0 until numOfColors){
            if (bin(numOfColors,i) == numOfPosters){
                return i.toInt()
            }
        }
        return null
    }

    private fun fact(i: Long):Long = if (i<2){
        1
    } else{
        i*fact(i-1)
    }

    private fun bin(a:Long,b:Long): Long? = when {
        a<b -> {
            null
        }
        a == b -> {
            1
        }
        else -> {
            fact(a)/((fact(a-b))*fact(b))
        }
    }
}