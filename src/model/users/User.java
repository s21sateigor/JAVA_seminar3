package model.users;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public abstract class User {
    String username;
    String nameAndSurname;
    String password;

    public void login(){

    }

    public void followPage(){

    }

}
