package assignment4;

import java.util.function.Consumer;
import java.util.regex.Pattern;

public class Entry implements Record, Consumer {
  private String name;
  private String email;
  private String organization;
  private String country;

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }

  public String getOrganization() {
    return this.organization;
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
        this.name, this.email, this.organization, this.country);

  }

  private Entry(EntryBuilder builder) {
    this.name = builder.name;
    this.email = builder.email;
    this.organization = builder.organization;
    this.country = builder.country;
  }

  // Builder
  public static class EntryBuilder {
    // required part : name
    private String name;

    // Optional parts
    private String email;
    private String organization;
    private String country;

    public EntryBuilder(String name) {
      this.name = name;
    }

    public EntryBuilder setEmail(String email) {
      String emailAdj = email.trim().replace(' ', '_');
      if (isValid(emailAdj)) {
        this.email = emailAdj;
      }
      return this;
    }

    private boolean isValid(String email2Validate) {
      Pattern p = Pattern.compile("[A-Za-z0-9._%-]+@[A-Za-z0-9.-_]+.[A-Za-z]{2,4}");

      if (p.matcher(email2Validate.trim()).matches()) {
        return true;
      } else {
        return false;
      }
    }

    public EntryBuilder setOrganization(String organization) {
      this.organization = organization;
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

  public boolean match(String pattern) {
    // need to match name, email, organization as per assignment requirement
    return (PatternUtil.match(pattern, this.name) || PatternUtil.match(pattern, this.email)
        || PatternUtil.match(pattern, this.organization));
  }

  @Override
  public void accept(Object t) {}
}
