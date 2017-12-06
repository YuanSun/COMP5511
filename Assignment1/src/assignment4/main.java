package assignment4;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class main {

  public static void main(String[] args) throws FileNotFoundException {
    AddressBook addressBook = new AddressBook();

    ArrayList<Entry> queryResult = addressBook.searchWithPattern("ria");

  }

}
