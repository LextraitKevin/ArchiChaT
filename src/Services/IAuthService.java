package Services;

import Models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

/**
 * Created by kevin on 31/05/2017.
 */
public interface IAuthService extends Remote {
	
	public int login( User user ) throws RemoteException;
	
	public int register( User user ) throws RemoteException;
	
	public void logout( User user ) throws RemoteException;
	
	public HashMap< Integer, User > getOnlineUsers() throws RemoteException;
}
