package assignment4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public interface Ass3Q7 {
  default public ArrayList<String> getData() throws IOException{
    URL url = getClass().getResource("ds17s-asg2-data.txt");
    File file = new File(url.getFile());
    FileInputStream fin = new FileInputStream(file.getAbsolutePath());
    BufferedReader br = new BufferedReader(
        new InputStreamReader(fin, "utf-8"));
    
    ArrayList<String> data = new ArrayList<>();
    try {
      String line;
      while ((line = br.readLine()) != null) {
        String name = new String(line.trim().getBytes(), "UTF-8");
          data.add(name);
      }
    } finally {
        br.close();
    }
    return data;
  }
  
  default public ArrayList<String> getSearchKey() {
    ArrayList<String> keysToSearch = new ArrayList<>();
    keysToSearch.add("Azevedo, Ana");
    keysToSearch.add("Silva, Rui");
    keysToSearch.add("Boussebough, Imane");
    keysToSearch.add("Terracina, Giorgio");
    keysToSearch.add("Lefebvre, Peter");
    keysToSearch.add("Houghten, Sher");
    keysToSearch.add("Revesz, Peter");
    
    return keysToSearch;
  }
}
