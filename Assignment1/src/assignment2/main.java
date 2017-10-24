package assignment2;

import java.io.IOException;

public class main {

  public static void main(String[] args) throws IOException {

    // Question 4
    Q4 q4 = new Q4();
    q4.countLinkedList();

    // Question 5
    Q5 q5 = new Q5();
    q5.reverseLinkedList();


    // Question 6
    Q6 q6 = new Q6(); // accept data

    // get two copies
    String[] str1 = new String[q6.data.size()];
    q6.data.toArray(str1);

    String[] str2 = new String[q6.data.size()];
    q6.data.toArray(str2);

    // use selection sort on str1, quick sort on str2
    long startTime1 = System.nanoTime();
    Q6.selectionSort(str1);
    long sortTime1 = System.nanoTime() - startTime1;

    long startTime2 = System.nanoTime();
    Q6.quickSort(str2);
    long sortTime2 = System.nanoTime() - startTime2;

    // check sort results
    // for (int i = 0; i < str1.length; i++) {
    // System.out.println(str1[i] + " - " + str2[i]);
    // }

    System.out.println("\nQuestion 6: \nSort time for selection sort is " + (double) sortTime1 / 1000000 + " mili seconds.\n"
        + "Sort time for quick sort is " + (double) sortTime2 / 1000000 + " mili seconds.");
  }

}
