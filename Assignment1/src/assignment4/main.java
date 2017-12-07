package assignment4;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class main {

  public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    AddressBook addressBook = new AddressBook();

    ArrayList<Entry> queryResult = addressBook.searchWithPattern("anca");
   

    addressBook.createIndex(IndexType.COUNTRY);
    addressBook.searchWithIndex(IndexType.COUNTRY, "China");

  }

}
