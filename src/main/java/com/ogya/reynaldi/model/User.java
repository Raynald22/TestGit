package com.ogya.reynaldi.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int userid;
 
 @Column(name = "email")
 private String email;
 
 @Column(name = "name")
 private String name; 

 @Column(name = "password")
 private String password;
 
 @Column(name = "active")
 private int active;
 
 @ManyToMany(cascade=CascadeType.ALL)
 @JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
 private Set<Role> roles;

 public int getUserId() {
  return userid;
 }

 public void setUserId(int userid) {
  this.userid = userid;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
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

 public int getActive() {
  return active;
 }

 public void setActive(int active) {
  this.active = active;
 }

 public Set<Role> getRoles() {
  return roles;
 }

 public void setRoles(Set<Role> roles) {
  this.roles = roles;
 }
}
