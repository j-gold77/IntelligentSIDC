import java.util.Random;

/**
 * The type Intelligence sidc.
 */
public class IntelligenceSIDC {



    static private boolean threshold = false;
    private int size = 0;
    /**
     * The Avl.
     */
    AVLTree avl = new AVLTree();
    /**
     * The Dll.
     */
    DoublyLinkedList dll = new DoublyLinkedList();

    /**
     * Instantiates a new Intelligence sidc.
     */
    public IntelligenceSIDC(){

    }

    /**
     * Size boolean.
     *
     * @param n the n
     * @return the boolean
     */
    public boolean size(int n){
        if(n<1000){
            return threshold;
        }
        else {
            return threshold = true;
        }
    }

    /**
     * Gets threshold.
     *
     * @return the threshold
     */
    public boolean getThreshold() {
        return threshold;
    }

    /**
     * Sets threshold.
     *
     * @param threshold the threshold
     */
    public static void setThreshold(boolean threshold) {
        IntelligenceSIDC.threshold = threshold;
    }

    /**
     * Generate long.
     *
     * @return the long
     */
    public long generate () {
        Random random = new Random();
        long n = 10000000 + random.nextInt(90000000);
        Student student = new Student();
        Node node = new Node(student);
        boolean istrue = true;
        if (threshold) {
            if (!avl.search(n))
                return n;
            else {
                generate();
            }
        } else {
            if (!dll.searchNode(n)) {
                return n;
            } else {
                generate();
            }
        }
        return n;
    }


    /**
     * Add.
     *
     * @param s the s
     */
    public void add(Student s){

        if(threshold) {
            if(!avl.search(s.getId())) {
                avl.insert(s);
                size++;
            }
        }
        else
            if(!dll.searchNode(s.getId())) {
                dll.insertFirst(s);
                size++;
            }
    }

    /**
     * Remove.
     *
     * @param key the key
     */
    public void remove (long key){
        if(threshold){
            if(avl.search(key)){
                avl.delete(key);
                size--;
            }
            else
                System.out.println("Sorry that key doesnt exist");
        }
        else{
            if(dll.searchNode(key)){
                dll.delete(key);
                size--;
            }
            else
                System.out.println("Sorry that key doesnt exist");

        }
    }

    /**
     * Get value student.
     *
     * @param key the key
     * @return the student
     */
    public Student getValue(long key){
        if(threshold) {
           return avl.searchValue(key);
        }
        else {
            return dll.searchValue(key);
        }

    }

    /**
     * All keys.
     */
    public void allKeys(){
        if(threshold) {
            avl.inorderRec(avl.getRoot());
            avl.printSorted();
        }
        else {
            dll.printSorted();
        }

    }

    /**
     * Next key string.
     *
     * @param key the key
     * @return the string
     */
    public String nextKey(long key){
        if(threshold){
            avl.inorderRec(avl.getRoot());
            return "The next key of " + key + " is: " + avl.nextKey(key);
        }
        else
            return "The next key of " + key + " is: " + dll.nextKey(key);

    }

    /**
     * Prev key string.
     *
     * @param key the key
     * @return the string
     */
    public String prevKey(long key){
        if(threshold){
            avl.inorderRec(avl.getRoot());
            return "The previous key of " + key + " is: " + avl.prevKey(key);
        }
        else
            return "The previous key of " + key + " is: " + dll.prevKey(key);
    }

    /**
     * Range key string.
     *
     * @param key1 the key 1
     * @param key2 the key 2
     * @return the string
     */
    public String rangeKey(long key1,long key2){
        if(key2<key1){
            return "Sorry that range isnt possible";
        }
        else {
            if (threshold){
                return "The number of keys between " + key1 + " and " + key2 + " is: " + avl.rangeKey(key1,key2);
            }
            else
                return "the number of keys between " + key1 + " and " + key2 +" is: " + dll.rangeKey(key1,key2);
        }

    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets size.
     *
     * @param size the size
     */
    public void setSize(int size) {
        this.size = size;
    }
}
