package Models;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by kevin on 31/05/2017.
 */
public class Message implements Serializable {
	private int id;
	private User author;
	private String content;
	private LocalDateTime timeStamp;


	public Message(int id, User author, String content, LocalDateTime timeStamp) {
		this.id = id;
		this.author = author;
		this.content = content;
		this.timeStamp = timeStamp;
	}

	public Message(int id, User author, String content) {
		this.id = id;
		this.author = author;
		this.content = content;
		this.timeStamp = LocalDateTime.now();
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

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}


}
