package assignment4;

import java.io.FileNotFoundException;

public class main {

  public static void main(String[] args) throws FileNotFoundException {
    AddressBook addressBook = new AddressBook();

    addressBook.displayAddressBook(addressBook.getSize() - 10, addressBook.getSize() - 1);
  }

}
