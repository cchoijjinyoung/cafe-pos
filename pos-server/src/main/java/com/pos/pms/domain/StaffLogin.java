package com.pos.pms.domain;

import com.pos.util.Prompt;

public class StaffLogin {
  private String Id;
  private String Password;
  private String Name;

  public StaffLogin(String Id, String Password, String Name) {
      this.Id = Id;
      this.Password = Password;
      this.Name = Name;
  }

  public String getId() {
      return Id;
  }

  public void setId(String Id) {
      this.Id = Id;
  }

  public String getPassword() {
      return Password;
  }

  public void setPassword(String Password) {
      this.Password = Password;
  }

  public String getName() {
      return Name;
  }

  public void setName(String Name) {
      this.Name = Name;
  }

  @Override
  public String toString() {
      return "ID : " + Id + " Password : " + Password + " Name : " + Name;
  }

  public void add() {
      StaffLogin m = new StaffLogin(Id, Password, Name);
      m.Id = Prompt.inputString("Id : ");
      m.Password = Prompt.inputString("Password : ");
      m.Name = Prompt.inputString("Name : ");
  }


}
