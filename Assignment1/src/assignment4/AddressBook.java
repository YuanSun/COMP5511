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
  public ArrayList<Entry> addressBook = new ArrayList<>();
  
  public AddressBook() throws FileNotFoundException {
    URL url = getClass().getResource("ds17s-Asg4-data.txt");
    File file = new File(url.getFile());
    FileInputStream fin=new FileInputStream(file.getAbsolutePath());
    BufferedReader br = new BufferedReader(
        new InputStreamReader(fin));
    try {
      String line;
      while ((line = br.readLine()) != null) {
        String delimiter = ":";
        String[] rawData = line.split(delimiter);
        String name = rawData[0] != null? rawData[0] : "";
        String email = rawData[1] != null ? rawData[1] : "";
        String school = rawData[2] != null ? rawData[2] : "";
        String country = rawData[3] != null ? rawData[3] : "";
        
        Entry entry = new Entry.EntryBuilder(name).setEmail(email).setSchool(school)
                    .setCountry(country).build();
        addressBook.add(entry);
       
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
}
