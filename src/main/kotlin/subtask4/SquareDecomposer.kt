package subtask4

class SquareDecomposer {

    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {
        val tempList = decNum(number.toLong(), number.toLong()*number.toLong())
        if (tempList != null) {
            val list = mutableListOf<Int>()
            for(item in 0 .. tempList.size-2) {
                list.add(tempList[item].toInt())
            }
            return list.toTypedArray()
        }
        return null
    }
    private fun decNum(num:Long, powNum:Long):MutableList<Long>?{
        if (powNum == 0L) {
            val res: MutableList<Long> = mutableListOf()
            res.add(num)
            return res
        }
        for (i in  (num - 1) downTo 0 step 1) {
            if ((powNum - i * i) >= 0) {
                val res = decNum(i, (powNum - i * i))
                if (res != null) {
                    res.add(num)
                    return res
                }
            }
        }
        return null
    }
}
