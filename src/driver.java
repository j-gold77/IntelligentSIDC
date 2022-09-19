import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class driver {


    public static void main(String[] args) {


        Scanner sc;
        PrintWriter pw;
        File file = new File("testfile2.txt");
        IntelligenceSIDC sidc = new IntelligenceSIDC();
        int count = 0;
        int count2 =0;
        Random random = new Random();



        try {
            sc = new Scanner(new FileInputStream(file));

            while (sc.hasNextLong()) {
                long n = sc.nextLong();
                count++;
                if(count==1000){
                    break;
                }
            }
            sc.close();


        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(count);

        try{
            sc = new Scanner(new FileInputStream(file));
            while (sc.hasNextLong()){
                sidc.size(count);
                Student student = new Student();
                String name = "s_" + count2;
                student.setInfo(name);
                student.setId(sc.nextLong());
                sidc.add(student);
                count2++;
            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




        try {
            pw = new PrintWriter(new FileOutputStream("testfile2_output.txt"));
            if(count>= 1000){
                pw.println("Will be using an AVL tree for this data structure.");
            }
            else
                pw.println("Will be using a Doubly Linked List for this data structure.");

            pw.println("The number of unique keys in this data structure is: " + sidc.getSize());
            sidc.remove(54065510);
            pw.println("removing key 54065510");
            pw.println("Now the size is: " + sidc.getSize());
            pw.println("Getting value now for key 69490946");
            pw.println(sidc.getValue(69490946));
            pw.println(sidc.nextKey(69490946));
            pw.println(sidc.prevKey(69490946));
            pw.println(sidc.rangeKey(69490946,65879539));


            pw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        sidc.allKeys();

    }
}
