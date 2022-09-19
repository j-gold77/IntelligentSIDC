/**
 * The type Student.
 */
public class Student {

    private String info;
    private long id;

    /**
     * Instantiates a new Student.
     */
    public Student(){
        info = null;
        id = 0;
    }

    /**
     * Instantiates a new Student.
     *
     * @param info the info
     * @param id   the id
     */
    public Student(String info,long id){
        this.info = info;
        this.id = id;
    }

    /**
     * Gets info.
     *
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * Sets info.
     *
     * @param info the info
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "info='" + info + '\'' +
                ", id=" + id +
                '}';
    }
}
