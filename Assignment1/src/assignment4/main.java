package assignment4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {

  public static void main(String[] args) throws IOException {
    AddressBook addressBook = new AddressBook();
    
    // question 1
    System.out.println("Question 1, query 'anca':");
    ArrayList<Entry> queryResult = addressBook.searchWithPattern("anca");
    System.out.println("\nQuestion 1, query 'McGill':");
    ArrayList<Entry> queryResult1 = addressBook.searchWithPattern("McGill");
    System.out.println("\nQuestion 1, query 'Valtchev@Canada.org':");
    ArrayList<Entry> queryResult2 = addressBook.searchWithPattern("Valtchev@Canada.org");
    System.out.println("\n\n\n");
    
    
    // question 2
    List<String> countryList = Arrays.asList("Canada", "France", "Germany", "Italy");
    
    System.out.println("Question 2:");
    addressBook.createIndex(IndexType.COUNTRY);
    addressBook.searchWithIndex(IndexType.COUNTRY, countryList, "To");

    
    // question 3
    System.out.println("\nQuestion 3:");
    BPlusTreeSearch treeSearch = new BPlusTreeSearch();
    treeSearch.displayResult();

  }

}