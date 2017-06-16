package ArchiChaT.Rest;

import ArchiChaT.Models.Message;
import ArchiChaT.Models.User;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by SMITHE on 14-Jun-17.
 */
public interface IRest<T> {
	
	public T getOne( int id ) throws RemoteException, NotBoundException;
	public ArrayList<T> getAll();
	public T put( int id, T resource );
	public T post( T resource );
	public void delete( int id );
	public Object lookupService(String serviceName) throws RemoteException, NotBoundException;

}
