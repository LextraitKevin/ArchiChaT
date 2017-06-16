package ArchiChaT.Rest;

import ArchiChaT.Models.Message;
import ArchiChaT.Models.User;

import java.util.ArrayList;

/**
 * Created by SMITHE on 14-Jun-17.
 */
public interface IRest<T> {
	
	public T getOne( int id );
	public ArrayList<T> getAll();
	public T put( int id, T resource );
	public T post( T resource );
	public void delete( int id );
	
	// --------------------------------- Users
	
	/*public ArrayList< User > getUsers();
	
	public User getUser( int userID );
	
	public User putUser( User user );
	
	public User postUser( User user );
	
	public void deleteUser( int userID );*/
	
	// --------------------------------- Messages
	/*public ArrayList< Message > getMessages();
	
	public Message getMessage( int messageID );
	
	public Message putMessage( Message message );
	
	public Message postMessage( Message message );
	
	public void deleteMessage( int messageID );*/
	
	// --------------------------------- Server
}
