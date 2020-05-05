package subtask6

import kotlin.collections.ArrayList


class FullBinaryTrees {

    class Node(var value: Int, var left: Node? = null, var right: Node? = null) {
        override fun toString(): String {
            return if (left != null && right != null) {
                "${left!!.value},${right!!.value}," + left.toString() + right.toString()
            } else {
                "${left.toString()},${right.toString()},"
            }
        }
    }

    fun stringForNodeCount(count: Int): String {
        var resultStr = ""
        for (node in fullTree(count)){
            var str = "[0,${node}]"

            str = str.replace(",]", "]")
            while (str.endsWith(",null,null]")) {
                str = str.replace(",null,null]", "]")
            }
            resultStr += str
        }

        print(resultStr)
        return "[$resultStr]"
    }

     fun fullTree(i: Int): ArrayList<Node> {
        if (i <= 0 || i % 2 == 0){
            return arrayListOf()
        }
        val res = arrayListOf<Node>()
        if (i == 1){
            res.add(Node(0))
            return res
        }
        for (j in 1 until i-1 step 2){
            val leftTrees = fullTree(j)
            val rightTrees = fullTree(i-j-1)
            for (lt in leftTrees){
                for (rt in rightTrees){
                    val root = Node(0)
                    root.left = lt
                    root.right = rt
                    res.add(root)
                }
            }
        }
        return res
    }
}
