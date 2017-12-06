package assignment4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class AddressBook {
  private ArrayList<Entry> addressBook = new ArrayList<>();
  // Question 2: inverted indices for organizations and countries
  private SortedMap<String, List<Entry>> orgIndex = new TreeMap<>();
  private SortedMap<String, List<Entry>> countryIndex = new TreeMap<>();
  private Set<String> orgStopWords = new HashSet<>();
  private Set<String> countryStopWords = new HashSet<>();

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
            // add school to stop words of organization
            orgStopWords.add(rawData[2] != null ? rawData[2] : "");
            break;

          case 4:
            Entry entry4Para = new Entry.EntryBuilder(rawData[0] != null ? rawData[0] : "")
                .setEmail(rawData[1] != null ? rawData[1] : "")
                .setSchool(rawData[2] != null ? rawData[2] : "")
                .setCountry(rawData[3] != null ? rawData[3] : "").build();
            addressBook.add(entry4Para);
         // add school to stop words of organization and country
            orgStopWords.add(rawData[2] != null ? rawData[2] : "");
            countryStopWords.add(rawData[3] != null ? rawData[3] : "");
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

  public ArrayList<Entry> searchWithPattern(String pattern) {
    ArrayList<Entry> result = new ArrayList<>();
    this.addressBook.forEach(entry -> {
      if (entry.match(pattern)) {
        result.add(entry);
      }
    });
    displaySearchResult(result);
    return result;
  }
  
  public void createOrgIndex() {
    if (addressBook.isEmpty()) {
      return;
    }
    
    
  }

  private void displaySearchResult(ArrayList<Entry> result) {
    System.out.printf("|%1$-40s | %2$-40s | %3$-75s | %4$-20s |\n",
        "Name", "Email Address", "School", "Country");
    System.out.printf("|%1$-40s | %2$-40s | %3$-75s | %4$-20s |\n",
        "----------------------------------------", "----------------------------------------",
        "---------------------------------------------------------------------------",
        "--------------------");
    result.forEach(entry -> {
      entry.displayRecord();
      System.out.println();
    });
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
