package hw221214Noda;

public class Node {
    public Integer value;
    public Node left;
    public Node right;

    private static boolean isNodeExist(Node node) {
        return node != null && node.value != null;
    }

    private static void createNode(Node node, int value) {
        node.left = new Node();
        node.right = new Node();
        node.value = value;
    }

    private static void insert(Node node, int value) {
        if (!isNodeExist(node)) {
            createNode(node, value);
        } else if (value < node.value) {
            insert(node.left, value);
        } else insert(node.right, value);
    }

    private static Node search(Node node, int value) {
        if (!isNodeExist(node)) return null;
        if (value == node.value) return node;
        if (value < node.value) {
            return search(node.left, value);
        } else
            return search(node.right, value);
    }

    private static Node getMin(Node node) {
        if (!isNodeExist(node)) {
            return null;
        }
        if (!isNodeExist(node.left)) {
            return node;
        }
        return getMin(node.left);
    }

    private static Node getMax(Node node) {
        if (!isNodeExist(node)) {
            return null;
        }
        if (!isNodeExist(node.right)) {
            return node;
        }
        return getMax(node.right);
    }

    private static void inOrderTraversal(Node node) {
        if (!isNodeExist(node)) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println("[ " + node.value + " ]" + getChildrenCount(node));
        inOrderTraversal(node.right);
    }

    private static void postOrderTraversal(Node node) {
        if (!isNodeExist(node)) {
            return;
        }
        inOrderTraversal(node.left);
        inOrderTraversal(node.right);
        System.out.println("[ " + node.value + " ]");
    }

    private static void directOrderTraversal(Node node) {
        if (!isNodeExist(node)) {
            return;
        }
        System.out.println("[ " + node.value + " ]");
        inOrderTraversal(node.left);
        inOrderTraversal(node.right);
    }

    private static void moveNode(Node toNode, Node fromNode) {
        if (!isNodeExist(toNode) && !isNodeExist(fromNode)) return;
        if (isNodeExist(toNode)) {
            toNode.value = (isNodeExist(fromNode)) ? fromNode.value : null;
        }
    }

    private static int getChildrenCount(Node node) {
        return ((node.left.value == null) ? 0 : 1) + ((node.right.value == null) ? 0 : 1);
    }

    private static Node getChildOrNull(Node node) {
        return (isNodeExist(node.left)) ? node.left : (isNodeExist(node.right)) ? node.right : null;
    }

    private static void removeNodeWithOneOrZeroChild(Node nodeToDelete) {
        Node childOrNull = getChildOrNull(nodeToDelete);
        moveNode(nodeToDelete, childOrNull);
        nodeToDelete.left = (childOrNull != null) ? childOrNull.left : null;
        nodeToDelete.right = (childOrNull != null) ? childOrNull.right : null;
    }

    //todo
    private static boolean remove(Node root, int value) {
        Node node = search(root, value);
        boolean isRemove;
        if (isNodeExist(node)) {
            if (getChildrenCount(node) < 2) {
                removeNodeWithOneOrZeroChild(node);
            } else {
                moveNode(node, getMin(node.right));
                removeNodeWithOneOrZeroChild(getMin(node.right));
            }
            isRemove = true;
        } else isRemove = false;
        return isRemove;
    }

    public static void main(String[] args) {
        Integer[] digit = {9, 2, 5, 13, 6, 10, 14, 7, 33, 44, 3, 4, 22, 19, 25, 18, 20};
        Node node = new Node();
        createNode(node, 9);
        for (int i = 1; i < digit.length; i++) {
            insert(node, digit[i]);
        }
        inOrderTraversal(node);
        postOrderTraversal(node);
        directOrderTraversal(node);

        remove(node, 10);
        System.out.println();
        inOrderTraversal(node);
    }
}
