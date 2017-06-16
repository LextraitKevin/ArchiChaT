package Services;

import java.io.*;
import java.rmi.RemoteException;
import java.util.HashMap;

/**
 * Created by kevin on 31/05/2017.
 */
public class PersistenceService implements IPersistenceService {

	@Override
	public Object read(String filename) throws RemoteException {

		Object content = null;
		try {
			File fI = new File(filename);

			if (fI.exists()) {

				FileInputStream fileI = new FileInputStream(filename);
				ObjectInputStream in = new ObjectInputStream(fileI);

				// Method for deserialization of object
				content = in.readObject();

				in.close();
				fileI.close();


			}
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
			return null;
		} catch (IOException ex) {
			System.out.println("IOException is caught");
			return null;
		}

		return content;

	}

	@Override
	public boolean write(String filename, Object content) throws RemoteException {

		try {

			//Saving of object in a file
			FileOutputStream fileO = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fileO);

			out.writeObject(content);

			out.close();
			fileO.close();

		} catch (IOException ex) {
			System.out.println("IOException is caught");
			return false;
		}

		return true;
	}
}
