package service;

import model.Page;
import model.Post;
import model.PostType;
import model.users.BusinessUser;
import model.users.GuestUser;
import model.users.PrivateUser;
import model.users.User;

import java.util.ArrayList;

public class MainService
{
    public static ArrayList<User> allRegisteredUsers = new ArrayList<>();
    public static void main(String[] args){
        //TODO
        //1. create 2 Guest User objects
        GuestUser guestUser = new GuestUser();
        GuestUser guestUser2 = new GuestUser();
        System.out.println(guestUser);
        System.out.println(guestUser2);
        System.out.println("------");
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
        privateUser.createPost(new Post("Man patīk programmēt!"), PostType.publicPost);
        privateUser.createPost(new Post("Man šodien viss ir apnicis."), PostType.privatePost);
        privateUser2.createPost(new Post("Man šodien jāiet pie ārsta."), PostType.privatePost);

        for(Post temp: privateUser.getAllPublicPosts()){
            System.out.println(temp);
        }

        for(Post temp: privateUser2.getAllPrivatePosts()){
            System.out.println(temp);
        }


        //5. create page for private user --> it is not allowed in our system
        //PrivateUser.addPage(); -- nevar uztaisit!
        //6. create at least one page for each Business User
        Page p1 = new Page("Mūzikas instrumenti Ventspilī", "Informācija par mūzikas instrumentiem Ventspilī.");
        businessUser.addPage(p1);
        Page p2 = new Page("Mūzikas instrumenti Liepājā", "Informācija par mūzikas instrumentiem Liepājā");
        businessUser.addPage(p2);


        //7. create at least one post in each page
        businessUser.createPostInPage(p1, businessUser.createPost(new Post("Ventspils svētkos 20% atlaide rozēm"), PostType.publicPost));
        businessUser.createPostInPage(p2, businessUser.createPost(new Post("Liepājas svētkos 10% atlaide tulpēm"), PostType.publicPost));
        businessUser.createPostInPage(p1, businessUser.createPost(new Post("Narcises par brīvu!"), PostType.publicPost));

        System.out.println("--------");

        for(Post temp: businessUser.getAllPages().get(0).getPostsInPage()){
            System.out.println(temp);
        }

        //8. verify login func.
        //guestUser.login(); <--- nevar
        System.out.println(privateUser.login());

        //9. verify followPage func.
        try {
            privateUser.followPage(p1);
            privateUser2.followPage(p1);
            privateUser2.followPage(p2);
        } catch (Exception e) {
            System.out.println(e);
        }

//        System.out.println(p1.getFollowers());
//        System.out.println(p2.getFollowers());

        //10. verify addFollower func.
        p1.addFollower(privateUser);
        p1.addFollower(privateUser2);
        System.out.println(p1.getFollowers());
        //11. verify removeFollower func.
        //12. verify increaseLikes func.
        for(int i = 0; i < 5; i++){
            privateUser.getAllPrivatePosts().get(0).increaseLikes();
        }

        for(int i = 0; i < 10; i++){
            businessUser.getAllPages().get(0).getPostsInPage().get(0).increaseLikes();
        }

        for(Post temp: privateUser.getAllPrivatePosts()){
            System.out.println(temp);
        }

        for(Post temp: privateUser2.getAllPrivatePosts()){
            System.out.println(temp);
        }

        System.out.println("---------");

        for(Post temp: businessUser.getAllPages().get(0).getPostsInPage()){
            System.out.println(temp);
        }
        System.out.println("-------------------");
        System.out.println(guestUser.findUsersByNameOrSurnameOrUsername("sia"));

        System.out.println("-------------------");
        System.out.println(privateUser.findPagesByTitleOrDescription("Vents"));

        System.out.println("--------------------");
        System.out.println(businessUser.findPublicPostsInPrivateUser("atlaid"));
    }
}
