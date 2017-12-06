package assignment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

  // Builder
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

  public boolean match(String pattern) {
    // need to match name, email, organization as per assignment requirement
    return (match(pattern, this.name) || match(pattern, this.email) || match(pattern, this.school));
  }

  // Question 1: search with Boyer-Moore Algorithm
  /*
   * Enhacement needed: input pattern and addressbook entry
   * need to be all in lower case before processing 
   */
  private boolean match(String pattern, String text) {
    if (text == null) {
      return false;
    }
    List<Integer> matches = new ArrayList<Integer>();
    int m = text.length();
    int n = pattern.length();
    Map<Character, Integer> rightMostIndexes = preprocessForBadCharacterShift(pattern);
    int alignedAt = 0;
    while (alignedAt + (n - 1) < m) {
      for (int indexInPattern = n - 1; indexInPattern >= 0; indexInPattern--) {
        int indexInText = alignedAt + indexInPattern;
        char x = text.charAt(indexInText);
        char y = pattern.charAt(indexInPattern);
        if (indexInText >= m)
          break;
        if (x != y) {
          Integer r = rightMostIndexes.get(x);
          if (r == null) {
            alignedAt = indexInText + 1;
          } else {
            int shift = indexInText - (alignedAt + r);
            alignedAt += shift > 0 ? shift : 1;
          }
          break;
        } else if (indexInPattern == 0) {
          matches.add(alignedAt);
          alignedAt++;
        }
      }
    }
    return !matches.isEmpty();
  }

  private static Map<Character, Integer> preprocessForBadCharacterShift(
      String pattern) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = pattern.length() - 1; i >= 0; i--) {
      char c = pattern.charAt(i);
      if (!map.containsKey(c))
        map.put(c, i);
    }
    return map;
  }
}
