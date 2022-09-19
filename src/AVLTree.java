import java.security.Key;
import java.util.ArrayList;

/**
 * The type Avl tree.
 */
public class AVLTree {

    private Node root;
    private int size = 0;
    /**
     * The Al.
     */
    ArrayList<Long> al = new ArrayList<>();

    private class Node {
        private Student student;
        private long key;
        private int balance;
        private int height;
        private Node left, right, parent;

        /**
         * Instantiates a new Node.
         *
         * @param s the s
         * @param k the k
         * @param p the p
         */
        Node(Student s,long k, Node p) {
            student = s;
            key = k;
            parent = p;
        }
    }

    /**
     * Insert.
     *
     * @param s the s
     */
    public void insert(Student s) {
        if (root == null) root = new Node(s,s.getId(), null);
        else {
            Node n = root;
            Node parent;
            while (n.key != s.getId()) {

                parent = n;

                boolean goLeft = n.key > s.getId();
                n = goLeft ? n.left : n.right;

                if (n == null) {
                    if (goLeft) {
                        parent.left = new Node(s, s.getId(), parent);
                    } else {
                        parent.right = new Node(s, s.getId(), parent);
                    }
                    rebalance(parent);
                    size++;
                    break;
                }
            }
        }
    }

    private void delete(Node node) {
        if (node.left == null && node.right == null) {
            if (node.parent == null) root = null;
            else {
                Node parent = node.parent;
                if (parent.left == node) {
                    parent.left = null;
                } else parent.right = null;
                size--;
                rebalance(parent);
            }
            return;
        }
        if (node.left != null) {
            Node child = node.left;
            while (child.right != null) child = child.right;
            node.key = child.key;
            delete(child);
        } else {
            Node child = node.right;
            while (child.left != null) child = child.left;
            node.key = child.key;
            delete(child);
        }
    }

    /**
     * Delete.
     *
     * @param delKey the del key
     */
    public void delete(long delKey) {
        if (root == null) return;
        Node node = root;
        Node child = root;

        while (child != null) {
            node = child;
            child = delKey >= node.key ? node.right : node.left;
            if (delKey == node.key) {
                size--;
                delete(node);
                return;
            }
        }
    }

    private void rebalance(Node n) {
        setBalance(n);

        if (n.balance == -2) {
            if (height(n.left.left) >= height(n.left.right)) n = rotateRight(n);
            else n = rotateLeftThenRight(n);

        } else if (n.balance == 2) {
            if (height(n.right.right) >= height(n.right.left)) n = rotateLeft(n);
            else n = rotateRightThenLeft(n);
        }

        if (n.parent != null) {
            rebalance(n.parent);
        } else {
            root = n;
        }
    }

    private Node rotateLeft(Node a) {

        Node b = a.right;
        b.parent = a.parent;

        a.right = b.left;

        if (a.right != null) a.right.parent = a;

        b.left = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }

        setBalance(a, b);

        return b;
    }

    private Node rotateRight(Node a) {

        Node b = a.left;
        b.parent = a.parent;

        a.left = b.right;

        if (a.left != null) a.left.parent = a;

        b.right = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }

        setBalance(a, b);

        return b;
    }

    private Node rotateLeftThenRight(Node n) {
        n.left = rotateLeft(n.left);
        return rotateRight(n);
    }

    private Node rotateRightThenLeft(Node n) {
        n.right = rotateRight(n.right);
        return rotateLeft(n);
    }

    private int height(Node n) {
        if (n == null) return -1;
        return n.height;
    }

    /**
     * Gets root.
     *
     * @return the root
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Sets root.
     *
     * @param root the root
     */
    public void setRoot(Node root) {
        this.root = root;
    }

    private void setBalance(Node... nodes) {
        for (Node n : nodes) {
            reheight(n);
            n.balance = height(n.right) - height(n.left);
        }
    }

    /**
     * Print balance.
     */
    public void printBalance() {
        printBalance(root);
    }

    private void printBalance(Node n) {
        if (n != null) {
            printBalance(n.left);
            System.out.printf("%s ", n.balance);
            printBalance(n.right);
        }
    }

    private void reheight(Node node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }

    /**
     * Search boolean.
     *
     * @param key the key
     * @return the boolean
     */
    public boolean search(long key) {
        Node result = searchHelper(this.root, key);
        return result != null;
    }

    /**
     * Search value student.
     *
     * @param key the key
     * @return the student
     */
    public Student searchValue(long key) {
        Node result = searchHelper(this.root, key);
        return result.student;
    }

    private Node searchHelper(Node root, long key) {
        // root is null or key is present at root
        if (root == null || root.key == key) return root;

        // key is greater than root's key
        if (root.key > key)
            return searchHelper(root.left, key); // call the function on the node's left child

        // key is less than root's key then
        // call the function on the node's right child as it is greater
        return searchHelper(root.right, key);
    }

    /**
     * Inorder rec.
     *
     * @param root the root
     */
    public void inorderRec(Node root)
    {


        if (root != null)
        {
            inorderRec(root.left);
            al.add(root.key);
            inorderRec(root.right);
        }
    }

    /**
     * Print sorted.
     */
    public void printSorted(){
        for(int i=0; i<al.size();i++){
            System.out.println(al.get(i));
        }
    }

    /**
     * Next key long.
     *
     * @param key the key
     * @return the long
     */
    public long nextKey(long key){
        return al.get(al.indexOf(key)+1);
    }

    /**
     * Prev key long.
     *
     * @param key the key
     * @return the long
     */
    public long prevKey(long key){
        return al.get(al.indexOf(key)-1);
    }


    /**
     * Range key int.
     *
     * @param key1 the key 1
     * @param key2 the key 2
     * @return the int
     */
    public int rangeKey(long key1, long key2){
        int count = 0;
        if(key2<key1){
            return -1;
        }
       return al.indexOf(key2)-al.indexOf(key1);
    }


}