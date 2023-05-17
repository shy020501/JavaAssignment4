import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FiboMultiThread extends Thread{
    private int num; // Store user input
    public int answer; // Store answer for the user input

    public FiboMultiThread(int num)
    {
        this.num = num;
    }

    public void run()
    {
        File file = new File("src/fibo.txt");
        if(num == 0) {
            answer = 0;
        } else if (num == 1 || num == 2) {
            answer = 1;
        } else {
            try {
                FiboMultiThread th1 = new FiboMultiThread(num - 1);
                FiboMultiThread th2 = new FiboMultiThread(num - 2);
                th1.start();
                th2.start();
                th1.join();
                th2.join();
                answer = th1.answer + th2.answer;
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(String.valueOf(answer) + "\n");
                writer.close();
            } catch (InterruptedException e1)
            {
                e1.printStackTrace(); // Error handling for joining thread
            } catch (IOException e2) {
                e2.printStackTrace(); // Error handling for file I/O
            }
        }
    }
}
