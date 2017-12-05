package assignment4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class AddressBook {
  private ArrayList<Entry> addressBook = new ArrayList<>();

  public AddressBook() throws FileNotFoundException {
    URL url = getClass().getResource("ds17s-Asg4-data.txt");
    File file = new File(url.getFile());
    FileInputStream fin = new FileInputStream(file.getAbsolutePath());
    BufferedReader br = new BufferedReader(
        new InputStreamReader(fin));
    try {
      String line;
      while ((line = br.readLine()) != null) {
        String delimiter = ":";
        String[] rawData = line.split(delimiter);
        switch (rawData.length) {
          case 1:
            Entry entry1Para = new Entry.EntryBuilder(rawData[0] != null ? rawData[0] : "").build();
            addressBook.add(entry1Para);
            break;

          case 2:
            Entry entry2Para = new Entry.EntryBuilder(rawData[0] != null ? rawData[0] : "")
                .setEmail(rawData[1] != null ? rawData[1] : "").build();
            addressBook.add(entry2Para);
            break;

          case 3:
            Entry entry3Para = new Entry.EntryBuilder(rawData[0] != null ? rawData[0] : "")
                .setEmail(rawData[1] != null ? rawData[1] : "")
                .setSchool(rawData[2] != null ? rawData[2] : "").build();
            addressBook.add(entry3Para);
            break;

          case 4:
            Entry entry4Para = new Entry.EntryBuilder(rawData[0] != null ? rawData[0] : "")
                .setEmail(rawData[1] != null ? rawData[1] : "")
                .setSchool(rawData[2] != null ? rawData[2] : "")
                .setCountry(rawData[3] != null ? rawData[3] : "").build();
            addressBook.add(entry4Para);
            break;

          default:
            break;
        }

      }
    } catch (NumberFormatException | IOException e) {
      e.printStackTrace();
    } finally {
      try {
        br.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public int getSize() {
    return this.addressBook.size();
  }

  public void displayAddressBook(int... index) {
    System.out.printf("|%1$-40s | %2$-40s | %3$-75s | %4$-20s |\n",
        "Name", "Email Address", "School", "Country");
    System.out.printf("|%1$-40s | %2$-40s | %3$-75s | %4$-20s |\n",
        "----------------------------------------", "----------------------------------------",
        "---------------------------------------------------------------------------",
        "--------------------");
    switch (index.length) {
      case 0:
        addressBook.forEach(entry -> {
          entry.displayRecord();
          System.out.println();
        });
        break;

      case 1:
        addressBook.subList(index[0], addressBook.size() - 1).forEach(entry -> {
          entry.displayRecord();
          System.out.println();
        });
        break;

      default:
        addressBook.subList(index[0], index[1]).forEach(entry -> {
          entry.displayRecord();
          System.out.println();
        });
        break;
    }

  }
}
