package service;

import model.users.BusinessUser;
import model.users.GuestUser;
import model.users.PrivateUser;
import model.users.User;

import java.util.ArrayList;

public class MainService
{
    public static ArrayList<User> allRegisteredUsers = new ArrayList<>();
    public static void main(String[] args) {
        //TODO
        //1. create 2 Guest User objects
        GuestUser guestUser = new GuestUser();
        GuestUser guestUser2 = new GuestUser();
        System.out.println(guestUser);
        System.out.println(guestUser2);
        System.out.println("-----");
        //2. create 2 Private User objects
        //TODO create register function for users
        //public boolean register(String name, String surname, String username, String password)
        PrivateUser privateUser = new PrivateUser("Jānis", "Kalniņš","janis.kalnins","12345678");
        PrivateUser privateUser2 = new PrivateUser("Faraons", "Sethijs","seth.pharaoh","87654321");
        allRegisteredUsers.add(privateUser);
        allRegisteredUsers.add(privateUser2);
        System.out.println(allRegisteredUsers);
        System.out.println("------");
        //3. create 2 Business User objects
        //TODO create register function for users
        BusinessUser businessUser = new BusinessUser("SIA", "Baroks", "sia.baroks","68686868");
        BusinessUser businessUser2 = new BusinessUser("SIA", "Dators", "sia.dators","69696969");
        allRegisteredUsers.add(businessUser);
        allRegisteredUsers.add(businessUser2);
        //4. create 1 private and 1 public posts for each Private User
        //5. create page for private user --> it is not allowed in our system
        //6. create at least one page for each Business User
        //7. create at least one post in each page

        //8. verify login func.
        //9. verify followPage func.
        //10. verify addFollower func.
        //11. verify removeFollower func.
        //12. verify increaseLikes func.

    }
}
