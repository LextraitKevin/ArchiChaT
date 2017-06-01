package Models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kevin on 31/05/2017.
 */
public class User implements Serializable {
	private int id;
	private String name;
	private String password;
	private ArrayList<User> friends;

	public User(int id) {
		this.id = id;
		this.friends = new ArrayList<User>();
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

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", friends=" + friends +
				'}';
	}
}
