package model.users;

import model.Page;
import model.Post;
import model.PostType;

import java.util.ArrayList;

public class BusinessUser extends User{

    private ArrayList<Page> allPages = new ArrayList<Page>();

    public ArrayList<Page> getAllPages(){
        return allPages;
    }

    public void addPage(Page page){
        if(page!=null & !allPages.contains(page)){
            allPages.add(page);
        }
    }

    @Override
    public Post createPost(Post post, PostType type) {
        if(post != null){
            return post;
        } else {
            return new Post();
        }
    }

    public void createPostInPage(Page page, Post post){
        if(page != null && post != null && !page.getPostsInPage().contains(post)){
            page.getPostsInPage().add(post);
        }
    }
}
