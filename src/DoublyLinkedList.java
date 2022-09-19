import java.util.ArrayList;
import java.util.Collections;

/**
 * The type Doubly linked list.
 */
public class DoublyLinkedList {

    private Node head;
    private Node tail;
    /**
     * The Size.
     */
    int size = 0;
    /**
     * The Al.
     */
    ArrayList<Long> al = new ArrayList<>();


    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Search node boolean.
     *
     * @param value the value
     * @return the boolean
     */
    public boolean searchNode(long value) {
        //Node current will point to head
        Node current = head;

        //Checks whether the list is empty
        if(head == null) {
            System.out.println("List is empty");
            return false;
        }
        while(current != null) {
            //Compare value to be searched with each node in the list
            if(current.student.getId() == value) {
                return true;
            }
            current = current.next;
        }
      return false;
    }

    /**
     * Search value student.
     *
     * @param value the value
     * @return the student
     */
    public Student searchValue(long value) {
        //Node current will point to head
        Node current = head;

        //Checks whether the list is empty
        if(head == null) {
            System.out.println("List is empty");
            return null;
        }
        while(current != null) {
            //Compare value to be searched with each node in the list
            if(current.student.getId() == value) {
                return current.student;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Delete.
     *
     * @param key the key
     */
    public void delete(long key) {
        Node temp = head;
        Node temp1 = null;
        while (temp.getstudent().getId() != key) {
            if(temp.next == null) {
                System.out.println("data not found");
                break;
            }
            temp1=temp;
            temp = temp.next;

        }
        if(temp.getstudent().getId() ==key) {
            temp=temp.next;
            temp.prev=temp1;
            temp1.next=temp;


        }

    }

    /**
     * Insert first.
     *
     * @param student the student
     */
// used to insert a node at the start of linked list
    public void insertFirst(Student student) {
        Node newNode = new Node(student);
        newNode.student = student;
        newNode.next = head;
        newNode.prev=null;
        if(head!=null)
            head.prev=newNode;
        head = newNode;
        if(tail==null)
            tail=newNode;
        al.add(student.getId());
        size++;
    }

    /**
     * Insert last.
     *
     * @param student the student
     */
// used to insert a node at the start of linked list
    public void insertLast(Student student) {
        Node newNode = new Node(student);
        newNode.student = student;
        newNode.next = null;
        newNode.prev=tail;
        if(tail!=null)
            tail.next=newNode;
        tail = newNode;
        if(head==null)
            head=newNode;
        size++;
    }

    /**
     * Delete first node.
     *
     * @return the node
     */
// used to delete node from start of Doubly linked list
    public Node deleteFirst() {

        if (size == 0)
            throw new RuntimeException("Doubly linked list is already empty");
        Node temp = head;
        head = head.next;
        head.prev = null;
        size--;
        return temp;
    }

    /**
     * Delete last node.
     *
     * @return the node
     */
// used to delete node from last of Doubly linked list
    public Node deleteLast() {

        Node temp = tail;
        tail = tail.prev;
        tail.next=null;
        size--;
        return temp;
    }


    /**
     * Delete after.
     *
     * @param after the after
     */
// Use to delete node after particular node
    public void deleteAfter(Node after) {
        Node temp = head;
        while (temp.next != null && temp.student != after.student) {
            temp = temp.next;
        }
        if (temp.next != null)
            temp.next.next.prev=temp;
        temp.next = temp.next.next;

    }

    /**
     * Print sorted.
     */
    public void printSorted(){

        al.sort(null);
        for(int i=0; i<al.size(); i++){
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
        al.sort(null);
        return al.get(al.indexOf(key)+1);
    }

    /**
     * Prev key long.
     *
     * @param key the key
     * @return the long
     */
    public long prevKey(long key){
        al.sort(null);
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
        al.sort(null);
        if(key2<key1){
            return -1;
        }
        return al.indexOf(key2)-al.indexOf(key1);
    }



}
 