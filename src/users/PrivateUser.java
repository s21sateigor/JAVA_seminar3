package users;

import java.util.ArrayList;

import model.Post;
import model.PostType;

public class PrivateUser extends User{

    private ArrayList<Post> allPrivatePosts = new ArrayList<>();
    private ArrayList<Post> allPublicPosts = new ArrayList<>();
    private ArrayList<PrivateUser> allPrivateUserFollowers = new ArrayList<>();

    public ArrayList<Post> getAllPrivatePosts() {
        return allPrivatePosts;
    }
    public ArrayList<Post> getAllPublicPosts() {
        return allPublicPosts;
    }
    public ArrayList<PrivateUser> getAllPrivateUserFollowers() {
        return allPrivateUserFollowers;
    }
    @Override
    public Post createPost(Post post, PostType type) {
        if(type.equals(PostType.privatePost) && !allPrivatePosts.contains(post)) {
            allPrivatePosts.add(post);
        }
        else if(type.equals(PostType.publicPost) && !allPublicPosts.contains(post)) {
            allPublicPosts.add(post);
        }
        return post;
    }

    //TODO add functions 1) addFollower and 2) removeFollower

}