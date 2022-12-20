package hw221214Noda;

public class Node<T> {
    public T value;
    public Node left;
    public Node right;

    private static boolean isNodeExist(Node node) {
        return node != null && node.value != null;
    }

    private void createNode(Node node, T value) {
        node.left = new Node();
        node.right = new Node();
        node.value = value;
    }

    private void insert(Node node, T value) {
        if (value instanceof Comparable) {
            if (!isNodeExist(node)) {
                createNode(node, value);
            } else if ((comparator(value, (T) node.value)) < 0) {
                insert(node.left, value);
            } else insert(node.right, value);
        }
    }

    private int comparator(T value1, T value2) {
        return ((Comparable) value1).compareTo(value2);
    }

    private Node search(Node node, T value) {
        if (!isNodeExist(node)) return null;
        if (comparator(value, (T) node.value) == 0) return node;
        if ((comparator(value, (T) node.value)) < 0) {
            return search(node.left, value);
        } else
            return search(node.right, value);
    }

    private Node getMin(Node node) {
        if (!isNodeExist(node)) {
            return null;
        }
        if (!isNodeExist(node.left)) {
            return node;
        }
        return getMin(node.left);
    }

    private Node getMax(Node node) {
        if (!isNodeExist(node)) {
            return null;
        }
        if (!isNodeExist(node.right)) {
            return node;
        }
        return getMax(node.right);
    }

    private void inOrderTraversal(Node node) {
        if (!isNodeExist(node)) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println("[ " + node.value + " ]" + getChildrenCount(node));
        inOrderTraversal(node.right);
    }

    private void postOrderTraversal(Node node) {
        if (!isNodeExist(node)) {
            return;
        }
        inOrderTraversal(node.left);
        inOrderTraversal(node.right);
        System.out.println("[ " + node.value + " ]");
    }

    private void directOrderTraversal(Node node) {
        if (!isNodeExist(node)) {
            return;
        }
        System.out.println("[ " + node.value + " ]");
        inOrderTraversal(node.left);
        inOrderTraversal(node.right);
    }

    private void moveNode(Node toNode, Node fromNode) {
        if (!isNodeExist(toNode) && !isNodeExist(fromNode)) return;
        if (isNodeExist(toNode)) {
            toNode.value = (isNodeExist(fromNode)) ? fromNode.value : null;
        }
    }

    private int getChildrenCount(Node node) {
        return ((node.left.value == null) ? 0 : 1) + ((node.right.value == null) ? 0 : 1);
    }

    private Node getChildOrNull(Node node) {
        return (isNodeExist(node.left)) ? node.left : (isNodeExist(node.right)) ? node.right : null;
    }

    private void removeNodeWithOneOrZeroChild(Node nodeToDelete) {
        Node childOrNull = getChildOrNull(nodeToDelete);
        moveNode(nodeToDelete, childOrNull);
        nodeToDelete.left = (childOrNull != null) ? childOrNull.left : null;
        nodeToDelete.right = (childOrNull != null) ? childOrNull.right : null;
    }

    //todo
    private boolean remove(Node root, T value) {
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
        node.createNode(node, 9);
        for (int i = 1; i < digit.length; i++) {
            node.insert(node, digit[i]);
        }
        node.inOrderTraversal(node);
        node.postOrderTraversal(node);
        node.directOrderTraversal(node);

        node.remove(node, 10);
        System.out.println();
        node.inOrderTraversal(node);
    }
}
