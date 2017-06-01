package Services;

import Models.User;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by kevin on 31/05/2017.
 */
public class AuthService implements IAuthService {

	private static final String userFileName = "bin/saveUser.txt";
	private ArrayList<User> onlineUsers;


	@Override
	public ArrayList<User> getOnlineUsers() {
		return onlineUsers;
	}


	@Override
	public int login(User user) {

		User savedUser = null;

		// Deserialization
		try {
			//TODO fix persistence

			// Reading the object from a file
			FileInputStream file = new FileInputStream(userFileName);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			savedUser = (User) in.readObject();

			in.close();
			file.close();

			onlineUsers.add(user);


			System.out.println("Object has been deserialized ");
			System.out.println(savedUser);

		} catch (IOException ex) {
			System.out.println("IOException is caught");
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}

		return 0;
	}

	@Override
	public int register(User user) {

		ArrayList<User> savedUsers = new ArrayList<User>();

		try {

			File fI = new File(userFileName);

			if (fI.exists()) {

				FileInputStream fileI = new FileInputStream(userFileName);
				ObjectInputStream in = new ObjectInputStream(fileI);

				// Method for deserialization of object
				savedUsers = (ArrayList) in.readObject();
				System.out.println(savedUsers);

				in.close();
				fileI.close();
			}

			//Saving of object in a file
			FileOutputStream fileO = new FileOutputStream(userFileName);
			ObjectOutputStream out = new ObjectOutputStream(fileO);

			savedUsers.add(user);

			// Method for serialization of object
			out.writeObject(savedUsers);


			out.close();
			fileO.close();


			System.out.println("Object has been serialized");
		} catch (IOException ex) {
			System.out.println("IOException is caught");
			System.out.println(ex);
			return -1;
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}

		return 0;
	}

	@Override
	public void logout(User user) {

		onlineUsers.remove(user);

	}
}

