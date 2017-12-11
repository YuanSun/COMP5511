package assignment4;

import java.io.IOException;
import java.util.ArrayList;

public class main {

  public static void main(String[] args) throws IOException {
    // Question 1
    System.out.println("Question 1:");
    AddressBook addressBook = new AddressBook();
    String searchKey = "anca";
    System.out.println("Searchh with \"" + searchKey + "\"");
    ArrayList<Entry> queryResult = addressBook.searchWithPattern(searchKey);
    
    searchKey = "McGill";
    System.out.println("\nSearch \"" + searchKey + "\"");
    addressBook.searchWithPattern(searchKey);

    //Question 2
    searchKey = "CA"; // search Country
    System.out.println("\nQuestion2:");
    System.out.println("Search country");
    addressBook.createIndex(IndexType.COUNTRY);
    addressBook.searchWithIndex(IndexType.COUNTRY, "CA");
    
    searchKey = "Technology";
    System.out.println("\nSearch organization");
    addressBook.createIndex(IndexType.ORGANIZATION);
    addressBook.searchWithIndex(IndexType.ORGANIZATION, searchKey);
    

    System.out.println("\nQuestion 3:");
    BPlusTreeSearch treeSearch = new BPlusTreeSearch();
    treeSearch.displayResult();

  }

}
