package assignment3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

public interface Q5 {
  default public ArrayList<String> getData() throws IOException{
    String FILENAME = "ds17s-asg2-data.txt";
    BufferedReader br = new BufferedReader(
        new InputStreamReader(new FileInputStream(FILENAME)));
    ArrayList<String> data = new ArrayList<>();
    try {
      String line;
      while ((line = br.readLine()) != null) {
          data.add(line.trim());
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
  
  public Map<String, Integer> search();
  
  public void displayResult();
}
