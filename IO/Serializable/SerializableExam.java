package IO.Serializable;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

/**
 * 
 */
public class SerializableExam {
    public static void main(String[] args) {
        Student student = new Student(1, "TIN");
        // persist(student);
        // depersist();
        new SerializableExam().writeFile(student);
    }

    /**
     * 
     */
    private static void depersist() {

        ObjectInputStream in = null;

        try {

            in = new ObjectInputStream(new FileInputStream("tin.txt"));
            Student s = (Student) in.readObject();
            System.out.println("result : " + s.name);
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

    private void writeFile(Student t) {
        BufferedWriter buffer = null;
        try {

            StringBuffer dataBuffer = new StringBuffer();
            buffer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("abc.txt")));
            dataBuffer.append("\"").append(t.getId()).append("\",");
            dataBuffer.append("\"").append(t.getName()).append("\",");
            if (dataBuffer.length() != 0) {
                buffer.write(dataBuffer.toString());
                dataBuffer.delete(0, dataBuffer.length());
                buffer.newLine();
            }
        } catch (Exception exception) {
            try {
                if (buffer != null) {
                    buffer.flush();
                    buffer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
				if (buffer != null) {
					buffer.flush();
					buffer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
        }

    }
}