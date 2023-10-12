package banksalad.bk135;

public class Main {


    public Integer findShortestPath(Node root) {
        if (root.isLeaf()) {
            return root.value;
        }
        return findPathRecursive(root, 0);
    }

    public int findPathRecursive(Node node, int dist) {
        dist += node.value;
        if (node.isLeaf()) {
            return dist;
        }
        int leftMin = Integer.MAX_VALUE;
        int rightMin = Integer.MAX_VALUE;
        if (node.leftChild != null) {
            leftMin = findPathRecursive(node.leftChild, dist);
        }
        if (node.rightChild != null) {
            rightMin = findPathRecursive(node.rightChild, dist);
        }
        return Math.min(leftMin, rightMin);
    }


    private static class Node {

        private final int value;

        private Node leftChild;

        private Node rightChild;

        private Node(int value) {
            this.value = value;
        }

        public Node(int value, Node leftChild, Node rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public boolean isLeaf() {
            return leftChild == null && rightChild == null;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

        assert main.findShortestPath(new Node(10)) == 10;
        assert main.findShortestPath(new Node(10, new Node(5), new Node(5))) == 15;
        assert main.findShortestPath(new Node(10, new Node(5, null, new Node(2)), new Node(5))) == 15;
        assert main.findShortestPath(new Node(10, new Node(5, null, new Node(2)), new Node(5, null, new Node(1)))) == 16;
        assert main.findShortestPath(new Node(10, new Node(5, null, new Node(2)), new Node(5, null, new Node(1, new Node(1), null)))) == 17;

    }
}


