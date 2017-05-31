package Models;

import java.util.Date;

/**
 * Created by kevin on 31/05/2017.
 */
public class Message {
    private int id;
    private User author;
    private String content;
    private Date timeStamp;


    public Message(int id, User author, String content, Date timeStamp) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.timeStamp = timeStamp;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }


}
