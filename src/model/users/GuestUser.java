package model.users;


import com.sun.tools.javac.Main;
import model.Page;
import model.Post;
import service.MainService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class GuestUser {
    private long generatedId;
    private static long idCounter = 0;

    public long getGeneratedId() {
        return generatedId;
    }

    public void setGeneratedId() {
        this.generatedId = idCounter++;
    }

    public GuestUser(){
        setGeneratedId();
    }

    @Override
    public String toString() {
        return "Guest User Nr." + generatedId;
    }


    public ArrayList<User> findUsersByNameOrSurnameOrUsername(String inputWord){
        ArrayList<User> result = new ArrayList<>();
        for (User user : MainService.allRegisteredUsers) {
            if(user.getName().contains(inputWord) || user.getSurname().contains(inputWord) || user.getUsername().contains(inputWord)){
                result.add(user);
            }
        }
        return result;
    }

    public ArrayList<Page> findPagesByTitleOrDescription(String inputWord){
        ArrayList<Page> result = new ArrayList<>();
        if(inputWord != null){
        for(User user: MainService.allRegisteredUsers){
            if(user instanceof BusinessUser){
                BusinessUser bUserTemp = (BusinessUser)user;
                for(Page tempPage: bUserTemp.getAllPages()){
                    if(tempPage.getTitle().contains(inputWord) || tempPage.getDescription().contains(inputWord)){
                        result.add(tempPage);
                    }
                }
            }
        }
        }
        return result;
    }

    public ArrayList<Post> findPublicPostsInPrivateUser(String inputWord){
        ArrayList<Post> result = new ArrayList<>();
        if(inputWord != null) {
            for (User user : MainService.allRegisteredUsers) {
                if (user instanceof PrivateUser) {
//                    PrivateUser pUserTemp = (PrivateUser) user;
                    for (Post tempPost: ((PrivateUser)user).getAllPublicPosts()){
                        if(tempPost.getMsg().toLowerCase().contains(inputWord.toLowerCase())){
                            result.add(tempPost);
                        }
                    }
                } else if(user instanceof BusinessUser) {
                    BusinessUser bUserTemp = (BusinessUser) user;
                    for(Page tempPage: bUserTemp.getAllPages()){
                        for(Post tempPost: tempPage.getPostsInPage()){
                            if(tempPost.getMsg().toLowerCase().contains(inputWord.toLowerCase())){
                                result.add(tempPost);
                            }
                        }
                    }
                }
            }
            //1. if user is Private
            //1.1. retrieve all public posts of each private user
            //2. if user is business
            //2.1. retrieve all Pages of each business user
            //2.2. retrieve all posts of each page
        }
        //return arraylist of posts

        return result;
        }

}
