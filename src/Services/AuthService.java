package Services;

import Models.User;

import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kevin on 31/05/2017.
 */
public class AuthService implements IAuthService {

	private static final String userFileName = "bin/saveUser.txt";
	private HashMap<Integer, User> onlineUsers = new HashMap<>();


	@Override
	public HashMap<Integer, User> getOnlineUsers() throws RemoteException {
		return onlineUsers;
	}


	@Override
	public int login(User user) throws RemoteException {

		PersistenceService ps = new PersistenceService();
		HashMap<Integer, User> savedUsers = new HashMap<Integer, User>();

		// Deserialization

		Object tmp = ps.read(userFileName);

		if (tmp != null) {
			savedUsers = (HashMap<Integer, User>) tmp;

			User tmpUser = savedUsers.get(user.getId());
			if (tmpUser != null && tmpUser.getPassword().equals(user.getPassword()) && tmpUser.getName().equals(user.getName())) {
				onlineUsers.put(user.getId(), user);
				System.out.println("user connected");
				return 0;
			}

		}

		System.out.println("user not connected");
		return -1;
	}

	@Override
	public int register(User user) throws RemoteException {

		HashMap<Integer, User> savedUsers = new HashMap<Integer, User>();

		PersistenceService ps = new PersistenceService();


		Object tmp = ps.read(userFileName);

		if (tmp != null)
			savedUsers = (HashMap<Integer, User>) tmp;


		savedUsers.put(user.getId(), user);

		if (ps.write(userFileName, savedUsers)) {
			savedUsers.remove(user.getId());
		}


		System.out.println("Object has been serialized");

		return 0;
	}

	@Override
	public void logout(User user) throws RemoteException {

		onlineUsers.remove(user.getId());

	}
}

