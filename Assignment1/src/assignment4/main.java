package assignment4;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class main {

  public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    AddressBook addressBook = new AddressBook();

    // ArrayList<Entry> queryResult = addressBook.searchWithPattern("anca");
    addressBook.createOrgIndex();

    addressBook.searchWithOrgIndex("Abran, Alain");

  }

}
