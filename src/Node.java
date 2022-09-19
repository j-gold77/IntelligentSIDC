/**
 * The type Node.
 */
public class Node {
    /**
     * The Student.
     */
    Student student; // holds the key
    /**
     * The Parent.
     */
    Node parent; // pointer to the parent
    /**
     * The Left.
     */
    Node left; // pointer to left child
    /**
     * The Right.
     */
    Node right; // pointer to right child
    /**
     * The Next.
     */
    Node next;
    /**
     * The Prev.
     */
    Node prev;
    /**
     * The Bf.
     */
    int bf; // balance factor of the node

    /**
     * Gets .
     *
     * @return the
     */
    public Student getstudent() {
        return student;
    }

    /**
     * Sets .
     *
     * @param student the student
     */
    public void setstudent(Student student) {
        this.student = student;
    }

    /**
     * Gets parent.
     *
     * @return the parent
     */
    public Node getParent() {
        return parent;
    }

    /**
     * Sets parent.
     *
     * @param parent the parent
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * Gets left.
     *
     * @return the left
     */
    public Node getLeft() {
        return left;
    }

    /**
     * Sets left.
     *
     * @param left the left
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * Gets right.
     *
     * @return the right
     */
    public Node getRight() {
        return right;
    }

    /**
     * Sets right.
     *
     * @param right the right
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * Gets student.
     *
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Sets student.
     *
     * @param student the student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * Gets next.
     *
     * @return the next
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets next.
     *
     * @param next the next
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Gets prev.
     *
     * @return the prev
     */
    public Node getPrev() {
        return prev;
    }

    /**
     * Sets prev.
     *
     * @param prev the prev
     */
    public void setPrev(Node prev) {
        this.prev = prev;
    }

    /**
     * Gets bf.
     *
     * @return the bf
     */
    public int getBf() {
        return bf;
    }

    /**
     * Sets bf.
     *
     * @param bf the bf
     */
    public void setBf(int bf) {
        this.bf = bf;
    }

    /**
     * Instantiates a new Node.
     *
     * @param student the student
     */
    public Node(Student student) {
        this.student = student;
        this.prev = null;
        this.next = null;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.bf = 0;
    }
}
