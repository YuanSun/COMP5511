package assignment4;

import java.util.regex.Pattern;

public class Entry implements Record {
  private String name;
  private String email;
  private String school;
  private String country;

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }

  public String getSchool() {
    return this.school;
  }

  public String getCountry() {
    return this.country;
  }

  @Override
  public Record getRecord() {
    return this;
  }

  @Override
  public void displayRecord() {
    System.out.printf("|%1$-40s | %2$-40s | %3$-75s | %4$-20s |",
        this.name, this.email, this.school, this.country);

  }

  private Entry(EntryBuilder builder) {
    this.name = builder.name;
    this.email = builder.email;
    this.school = builder.school;
    this.country = builder.country;
  }

  public static class EntryBuilder {
    // required part : name
    private String name;

    // Optional parts
    private String email;
    private String school;
    private String country;

    public EntryBuilder(String name) {
      this.name = name;
    }

    public EntryBuilder setEmail(String email) {
      if (isValid(email)) {
        this.email = email;
      }
      return this;
    }

    private boolean isValid(String email2Validate) {
      Pattern p = Pattern.compile("[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,4}");

      if (p.matcher(email2Validate.trim()).matches()) {
        return true;
      } else {
        return false;
      }
    }

    public EntryBuilder setSchool(String school) {
      this.school = school;
      return this;
    }

    public EntryBuilder setCountry(String country) {
      this.country = country;
      return this;
    }

    public Entry build() {
      return new Entry(this);
    }
  }
}
