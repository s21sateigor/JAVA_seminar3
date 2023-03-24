package model;

import lombok.AllArgsConstructor;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
public class Post {
    private String msg;
    private LocalDateTime dateTime;
    //TODO need to change to ArrayList of User, which set the like to this post
    private int countOfLikes = 0;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String inputMsg) {
        if(inputMsg!=null && inputMsg.length() > 3){
            msg = inputMsg;
        } else {
            msg = "-----";
        }
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }

    public int getCountOfLikes() {
        return countOfLikes;
    }

    public void increaseLikes(){
        countOfLikes++;
    }

    public Post(){
        setDateTime();
        setMsg("New Post");
    }

    public Post(String msg){
        setMsg(msg);
    }

    @Override
    public String toString() {
        return dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"))
                + "--> " + msg + " (" + countOfLikes + ") ";
    }
}
