package IO.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 */
public class SerializableExam {
    public static void main(String[] args) {
        Student student = new Student(1, "TIN");
        persist(student);
        depersist();
    }

    /**
     * 
     */
    private static void depersist() {

         ObjectInputStream in = null;

        try {
            
            in = new ObjectInputStream(new FileInputStream("tin.txt"));
            Student s = (Student) in.readObject();
            System.out.println( "result : " + s.name);
        } catch (Exception e) {

        } finally {
             try {
                in.close();

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

    /**
     * 
     * @param student
     */
    private static void persist(Student student) {
        FileOutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            outputStream = new FileOutputStream("tin.txt");
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(student);
        } catch (Exception e) {

        } finally {
            try {
                objectOutputStream.flush();
                objectOutputStream.close();

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }
}