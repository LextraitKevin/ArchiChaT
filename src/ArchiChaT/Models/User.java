package ArchiChaT.Models;

import org.pojomatic.annotations.AutoProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by kevin on 31/05/2017.
 */
@XmlRootElement
@XmlType( name = "users" )
@XmlAccessorType( XmlAccessType.FIELD )
@AutoProperty
public class User implements Serializable {
	private int id;
	private String name;
	private String password;
	private ArrayList< User > friends;
	private HashMap< Integer, User > friendsRequest;
	
	public User() {
	}
	
	public User( int id ) {
		this.id = id;
		this.friends = new ArrayList< User >();
	}

	public User(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = hashPassword(password);
		this.friends = new ArrayList<User>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<User> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<User> friends) {
		this.friends = friends;
	}

	public String hashPassword() {
		//TODO
		return this.password;
	}

	public String hashPassword(String password) {
		//TODO
		return password;
	}

	public HashMap<Integer, User> getFriendsRequest() {
		return friendsRequest;
	}

	public void setFriendsRequest(HashMap<Integer, User> friendsRequest) {
		this.friendsRequest = friendsRequest;
	}

	@Override
	public String toString() {
		return "User[" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", friends=" + friends +
				']';
	}
}