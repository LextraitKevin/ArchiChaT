package ArchiChaT.Services;


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by kevin on 31/05/2017.
 */
public interface IPersistenceService extends Remote {

	public Object read(String filename) throws RemoteException;
	public boolean write(String filename,Object content) throws RemoteException;

}
