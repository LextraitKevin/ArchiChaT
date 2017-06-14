package Services;

import Models.Message;
import Models.User;

import java.util.ArrayList;

/**
 * Created by SMITHE on 14-Jun-17.
 */
public interface IRest {
	// --------------------------------- Users
	
	public ArrayList< User > getUsers();
	
	public User getUser( int userID );
	
	public User putUser( User user );
	
	public User postUser( User user );
	
	public void deleteUser( int userID );
	
	// --------------------------------- Messages
	public ArrayList< Message > getMessages();
	
	public Message getMessage( int messageID );
	
	public Message putMessage( Message message );
	
	public Message postMessage( Message message );
	
	public void deleteMessage( int messageID );
	
	// --------------------------------- Server
}
