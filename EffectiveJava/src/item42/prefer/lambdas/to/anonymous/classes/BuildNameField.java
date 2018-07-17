package item42.prefer.lambdas.to.anonymous.classes;

public enum BuildNameField {
  BUILDNAME("buildName");

  private String fieldName;

  private BuildNameField(String fieldName) {
    this.fieldName = fieldName;
  }

  public String getName() {
    return this.fieldName;
  }
}
