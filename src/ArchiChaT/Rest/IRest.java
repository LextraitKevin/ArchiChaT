package ArchiChaT.Rest;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by SMITHE on 14-Jun-17.
 */
public interface IRest< T > {
	
	public T getOne( int id ) throws RemoteException, NotBoundException;

	public ArrayList<T> getAll() throws RemoteException, NotBoundException;
	public T put( int id, T resource ) throws RemoteException, NotBoundException;
	public T post( T resource ) throws RemoteException, NotBoundException;
	public void delete( int id ) throws RemoteException, NotBoundException;
	public Object lookupService(String serviceName) throws RemoteException, NotBoundException;
}
