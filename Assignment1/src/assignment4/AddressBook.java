package assignment4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class AddressBook {
  private ArrayList<Entry> addressBook = new ArrayList<>();
  // Question 2: inverted indices for organizations and countries
  private SortedMap<String, List<Tuple>> orgIndex = new TreeMap<>();
  private SortedMap<String, List<Tuple>> countryIndex = new TreeMap<>();
  private Set<String> orgs = new HashSet<>();
  private Set<String> countries = new HashSet<>();
  private int count;


  public AddressBook() throws FileNotFoundException, UnsupportedEncodingException {
    URL url = getClass().getResource("ds17s-Asg4-data.txt");
    File file = new File(url.getFile());
    FileInputStream fin = new FileInputStream(file.getAbsolutePath());
    BufferedReader br = new BufferedReader(
        new InputStreamReader(fin, "utf-8"));
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
                .setOrganization(rawData[2] != null ? rawData[2] : "").build();
            addressBook.add(entry3Para);
            orgs.add(rawData[2]);
            break;

          case 4:
            Entry entry4Para = new Entry.EntryBuilder(rawData[0] != null ? rawData[0] : "")
                .setEmail(rawData[1] != null ? rawData[1] : "")
                .setOrganization(rawData[2] != null ? rawData[2] : "")
                .setCountry(rawData[3] != null ? rawData[3] : "").build();
            addressBook.add(entry4Para);
            orgs.add(rawData[2]);
            countries.add(rawData[3]);
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

  public void createIndex() {
    // create index for org
    createIndex(IndexType.ORGANIZATION);
    
    // create index for country
    createIndex(IndexType.COUNTRY);
  }
  
  private void createIndex(IndexType indexType) {
    if (indexType.equals(IndexType.ORGANIZATION)) {
      createIndex(IndexType.ORGANIZATION, orgIndex);
    } else if (indexType.equals(IndexType.COUNTRY)) {
      createIndex(IndexType.COUNTRY, countryIndex);
    } else {
      System.out.println("Index type is not valid!!!");
    }
  }

  private void createIndex(IndexType indexType, SortedMap<String, List<Tuple>> index) {
    if (addressBook.isEmpty()) {
      return;
    }

    addressBook.forEach(entry -> {
      if (indexType.equals(IndexType.ORGANIZATION) && entry.getOrganization() != null) {
        List<Tuple> idx = index.get(entry.getOrganization());
        if (idx == null) {
          idx = new LinkedList<Tuple>();
          index.put(entry.getOrganization(), idx);
        }
        idx.add(new Tuple(entry.getOrganization(), addressBook.indexOf(entry)));
      } else if (indexType.equals(IndexType.COUNTRY) && entry.getCountry() != null) {
        List<Tuple> idx = index.get(entry.getCountry());
        if (idx == null) {
          idx = new LinkedList<Tuple>();
          index.put(entry.getCountry(), idx);
        }
        idx.add(new Tuple(entry.getCountry(), addressBook.indexOf(entry)));
      }
    });
    System.out.println("\n" + indexType.toString() + " is indexed!\n");
  }

  private void createIndexMsg() {
    System.out.println("\nData haven't been indexed. Create index first!!!");
  }

  // first parameter is organization, second is country
  public void searchWithIndex(String org, String country) {
    int searchCount = 0;
    Map<String, List<Entry>> orgResult = new HashMap<>();
    Map<String, List<Entry>> countryResult = new HashMap<>();
    orgResult = searchWithIndex(IndexType.ORGANIZATION, org);
    searchCount = count;
    countryResult = searchWithIndex(IndexType.COUNTRY, country);
    searchCount += count;
    
    Collection<List<Entry>> result;
    result = orgResult.values();
    result.retainAll(countryResult.values());
   
    
    if (!result.isEmpty()) {

      System.out.println(org + "--" + country + " search result: \n");
      result.forEach((keyMatch, entries) -> {
        System.out.println(keyMatch + ":");
        entries.forEach(e -> {
          count++;
          e.displayRecord();
          System.out.println();
        });
        System.out.println();
      });
      System.out.println("Found " + count + " results.\n");
    } else {
      System.out.println("Nothing found!");
    }
  }
  
  private Map<String, List<Entry>> searchWithIndex(IndexType indexType, String key) {
    count = 0;
    Map<String, List<Entry>> result = new HashMap<>();

    if ((indexType.equals(IndexType.ORGANIZATION) && orgIndex.isEmpty())
        || (indexType.equals(IndexType.COUNTRY) && countryIndex.isEmpty())) {
      createIndexMsg();
      return null;
    }

    if (indexType.equals(IndexType.ORGANIZATION)) {
      result = searchByKeys(orgs, orgIndex, key);
    }

    if (indexType.equals(IndexType.COUNTRY)) {
      result = searchByKeys(countries, countryIndex, key);
    }
    return result;

  }

  private Map<String, List<Entry>> searchByKeys(Set<String> keySet, SortedMap<String, List<Tuple>> index, String key) {
    // pattern match before search
    // define how many orgs are match the search key
    ArrayList<String> keysToSearch = new ArrayList<>();
    keySet.forEach(_key -> {
      if (PatternUtil.match(key, _key)) {
        keysToSearch.add(_key);
      }
    });

    Map<String, List<Entry>> result = new HashMap<>();
    if (!keysToSearch.isEmpty()) {
      keysToSearch.forEach(keyToSearch -> {
        List<Tuple> idx = index.get(keyToSearch);
        if (idx != null) {
          List<Entry> searchResult = new LinkedList<>();
          for (Tuple t : idx) {
            searchResult.add(addressBook.get(t.position));
          }
          result.put(keyToSearch, searchResult);
        }
      });

    }
    
    return result;
  }

  private void displaySearchResult(ArrayList<Entry> result) {
    System.out.printf("|%1$-40s | %2$-40s | %3$-75s | %4$-20s |\n",
        "Name", "Email Address", "Organization", "Country");
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
        "Name", "Email Address", "Organization", "Country");
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

  private class Tuple {
    private String key;
    private int position;

    public Tuple(String key, int position) {
      this.key = key;
      this.position = position;
    }
  }

}
