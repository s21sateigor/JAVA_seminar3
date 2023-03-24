package model.users;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public abstract class User {
    private String username;
    private String encodedPassword;
    private String name;
    private String surname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String inputUsername) {
        if(inputUsername != null && inputUsername.matches("[a-z0-9.]{8,20}")){
            username = inputUsername;
        } else {
            username = "default.user";
        }
    }

    public String getEncodedPassword() {
        return encodedPassword;
    }

    public void setEncodedPassword(String inputEncodedPassword) {
        if(encodedPassword != null && encodedPassword.matches("[A-Za-z0-0]{8,20}")){
            encodedPassword = inputEncodedPassword;
        } else {
            encodedPassword = "defaultpassword";
        }
    }

    //TODO verification for setName and setSurname
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void login(){

    }

    public void followPage(){

    }

}
