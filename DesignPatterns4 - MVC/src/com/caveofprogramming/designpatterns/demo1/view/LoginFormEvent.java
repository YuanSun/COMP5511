package com.caveofprogramming.designpatterns.demo1.view;
/*this is a BEAN class
  The class stores some data which also has getter and setter in it. 

*/
public class LoginFormEvent { 
  private String name;
  private String password;
  
  public LoginFormEvent(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  
}
