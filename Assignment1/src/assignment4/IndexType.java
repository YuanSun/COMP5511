package assignment4;

public enum IndexType {
  ORGANIZATION("Organization"), COUNTRY("Country");

  private final String name;

  private IndexType(String s) {
    this.name = s;
  }

  public String toString() {
    return this.name;
  }
}
