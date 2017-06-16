package ArchiChaT.Models;

import org.pojomatic.annotations.AutoProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by kevin on 31/05/2017.
 */

@XmlRootElement
@XmlType( name = "messages" )
@XmlAccessorType( XmlAccessType.FIELD )
@AutoProperty
public class Message implements Serializable {
	private int id;
	private User author;
	private User receipUser;
	private String content;
	private LocalDateTime timeStamp;
	
	public Message() {
	}
	
	public Message( int id, User author, String content, User receipUser) {
		this.id = id;
		this.author = author;
		this.content = content;
		this.timeStamp = LocalDateTime.now();
		this.receipUser = receipUser;

	}
	public Message(int id, User author, String content, LocalDateTime timeStamp, User receipUser) {
		this.id = id;
		this.author = author;
		this.content = content;
		this.timeStamp = timeStamp;
		this.receipUser = receipUser;

	}

	@Override
	public String toString() {
		return "Message{" +
				"id=" + id +
				", author=" + author +
				", content='" + content + '\'' +
				", timeStamp=" + timeStamp +
				", ReceipUser" + receipUser +
				'}';
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

	public User getReceipUser() {
		return receipUser;
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
