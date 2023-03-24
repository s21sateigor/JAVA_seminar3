package model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private String msg;
    private LocalDateTime dateTime;
    //TODO need to change to ArrayList of User, which set the like to this post
    private int countOfLikes;

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
}
