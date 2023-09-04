package com.bci.prueba;

class RequestUser {

  private String name;
  private String email;
  private String pass;
  private Phone[] phones;

  RequestUser() {}

  RequestUser(String name, String email) {

    this.name = name;
    this.email = email;
  }

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }
  
  public String getPass() {
    return this.pass;
  }
  
  public Phone[] getPhones() {
    return this.phones;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  public void setPass(String pass) {
    this.pass = pass;
  }
  
  public void setPhones(Phone[] phones) {
    this.phones = phones;
  }
}