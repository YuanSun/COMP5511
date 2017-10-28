package assignment3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q5Diction implements Q5{
  private ArrayList<String> data = new ArrayList<>();
  private ArrayList<String> keyToSearch = new ArrayList<>();
  Map<String, List<Integer>> index = new HashMap<String, List<Integer>>();
  
  public Q5Diction() throws IOException {
    data = this.getData();
    keyToSearch = this.getSearchKey();
  }
  
  public void indexData() {
    data.forEach(name -> {
      if(keyToSearch.contains(name)) {
        List<Tuple> idx = index.get(name);
        if(idx == null) {
          idx = new LinkedList<Tuple>();
          index.put(name, idx);
        }
        idx.add(new Tuple())
      }
    });
  }
  
  
    
}
