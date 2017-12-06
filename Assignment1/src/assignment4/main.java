package assignment4;

import java.io.FileNotFoundException;

public class main {

  public static void main(String[] args) throws FileNotFoundException {
    AddressBook addressBook = new AddressBook();

    //ArrayList<Entry> queryResult = addressBook.searchWithPattern("ria");
    addressBook.createOrgIndex();
    
    addressBook.searchWithOrgIndex("Abran, Alain");

  }

}
