package IO.PipeStreamExam;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeStreamExample {

    private InputStream pis;

    public static void main(String[] args) throws IOException, InterruptedException {
        new PipeStreamExample().test();
    }

    private void test() throws IOException, InterruptedException {
        PipedOutputStream pos = new PipedOutputStream();
        pis = new PipedInputStream(pos);

        new ThreadRead().start();
        char[] chs = new char[] { 'a', 'a', 'b', 'c', 'e' };

        for (char ch:chs) {
            pos.write(ch);
            Thread.sleep(1000);
        }
        pos.close();
    }

    class ThreadRead extends Thread {
        @Override
        public void run() {
            try {
                int data = 0;
                while ((data = pis.read()) != -1) {
                    System.out.println((char) data);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (pis != null) {
                    try {
                        pis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } 
            }
        }
    }
}