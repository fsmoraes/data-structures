class Node(
    var value: Int,
    var left: Node? = null,
    var right: Node? = null
)

class BinarySearchTree {
    private var root: Node? = null

    fun insert(value: Int): BinarySearchTree? {
        val newNode = Node(value)

        if (root == null) {
            root = newNode
            return this
        }

        var current = root

        while (true) {
            if (value == current!!.value) return null

            if (value < current.value) {
                if (current.left == null) {
                    current.left = newNode
                    return this
                }
                current = current.left
            } else {
                if (current.right == null) {
                    current.right = newNode
                    return this
                }
                current = current.right
            }
        }
    }

    fun find(value: Int): Node? {

        if (root == null) return null

        var found = false
        var currentNode = root

        while (currentNode != null && !found) {
            when {
                value < currentNode!!.value -> currentNode = currentNode.left
                value > currentNode!!.value -> currentNode = currentNode.right
                else -> found = true
            }
        }

        return currentNode
    }
}

fun main() {
    var bts = BinarySearchTree()

    bts.insert(10)
    bts.insert(5)
    bts.insert(13)
    bts.insert(7)
    bts.insert(11)
    bts.insert(16)
    bts.insert(2)

    println(bts.find(5)?.value)
    println(bts.find(2)?.value)
    println(bts.find(90)?.value)
}