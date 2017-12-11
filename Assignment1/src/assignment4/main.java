package assignment4;

import java.io.IOException;
import java.util.ArrayList;

public class main {

  public static void main(String[] args) throws IOException {
    AddressBook addressBook = new AddressBook();


    ArrayList<Entry> queryResult = addressBook.searchWithPattern("anca");


    addressBook.createIndex();
    addressBook.searchWithIndex("Technology", "Canada");

    BPlusTreeSearch treeSearch = new BPlusTreeSearch();
    treeSearch.displayResult();

  }

}
