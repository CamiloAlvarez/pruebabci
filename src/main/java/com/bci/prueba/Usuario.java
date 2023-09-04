package com.bci.prueba;

import java.util.Objects;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
class Usuario {

  private @Id @GeneratedValue Long id;
  private String name;
  private String email;
  private String pass;
  private String created;
  private String modified;
  private Long isActive;
  private String token;
  private String lastLogin;
  //private Phone phones;

  Usuario() {}

  Usuario(String name, String email) {

    this.name = name;
    this.email = email;
  }

  public Long getId() {
    return this.id;
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
  
  public String getCreated() {
    return this.created;
  }
  
  public String getModified() {
    return this.modified;
  }
  
  public Long getIsActive() {
    return this.isActive;
  }
  
  public String getToken() {
    return this.token;
  }
  
  public String getLastLogin() {
    return this.lastLogin;
  }

  public void setId(Long id) {
    this.id = id;
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
  
  public void setCreated(String created) {
    this.created = created;
  }
  
  public void setModified(String modified) {
    this.modified = modified;
  }
  
  public void setIsActive(Long isActive) {
    this.isActive = isActive;
  }
  
  public void setToken(String token) {
    this.token = token;
  }
  
  public void setLastLogin(String lastLogin) {
    this.lastLogin = lastLogin;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Usuario))
      return false;
    Usuario user = (Usuario) o;
    return Objects.equals(this.id, user.id) && Objects.equals(this.name, user.name)
        && Objects.equals(this.email, user.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.email);
  }

  @Override
  public String toString() {
	  return "Usuario{" + "id=" + this.id + ", name='" + this.name + '\'' + ", email='" + this.email + '\'' + '}';
  }
}