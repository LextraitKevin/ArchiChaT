package ArchiChaT.Services;

import ArchiChaT.Models.Message;
import ArchiChaT.Models.User;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kevin on 31/05/2017.
 */
public class UserManagementService implements IUserManagementService {
	
	@Override
	public ArrayList< User > findAll() throws RemoteException {
		PersistenceService p = new PersistenceService();
		ArrayList< User > userArrayList = new ArrayList<>();
		
		Object res = p.read( AuthService.USER_FILE_NAME );
		
		if ( res != null )
			userArrayList.addAll( ( ( HashMap< Integer, User > ) res ).values() );
		
		return userArrayList;
	}
	
	@Override
	public User find( int uId ) throws RemoteException {
		PersistenceService p = new PersistenceService();
		User user = null;
		
		Object res = p.read( AuthService.USER_FILE_NAME );
		
		if ( res != null )
			user = ( ( HashMap< Integer, User > ) res ).get( uId );
		
		return user;
	}
	
	public User update( User user ) throws RemoteException {
		PersistenceService p = new PersistenceService();
		HashMap< Integer, User > savedUsers = new HashMap< Integer, User >();
		
		Object tmp = p.read( AuthService.USER_FILE_NAME );
		
		if ( tmp != null )
			savedUsers = ( HashMap< Integer, User > ) tmp;
		
		savedUsers.put( user.getId(), user );
		
		if ( p.write( AuthService.USER_FILE_NAME, savedUsers ) ) {
			savedUsers.remove( user.getId() );
		}
		
		return user;
	}
	
	public void delete( int uID) throws RemoteException{
		PersistenceService p = new PersistenceService();
		HashMap< Integer, User > savedUsers = new HashMap< Integer, User >();
		
		Object tmp = p.read( AuthService.USER_FILE_NAME );
		
		if ( tmp != null )
			savedUsers = ( HashMap< Integer, User > ) tmp;
		
		savedUsers.remove( uID );
		
		if ( p.write( AuthService.USER_FILE_NAME, savedUsers ) ) {
			savedUsers.remove( uID );
		}
	}
	
	@Override
	//TODO
	public ArrayList< Message > findPreviousRecords( User user, AuthService auth ) throws RemoteException {
		
		return null;
	}
	
	
	/**
	 * Returns the User user's online friends
	 *
	 * @param user
	 * @param auth
	 * @return
	 */
	@Override
	public ArrayList< User > findOnlineFriends( User user, AuthService auth ) throws RemoteException {
		ArrayList< User > onlineFriends = new ArrayList<>();
		for ( User friend : user.getFriends() ) {
			for ( int i = 1; i <= auth.getOnlineUsers().size(); i++ ) {
				if ( auth.getOnlineUsers().get( i ).getId() == friend.getId() ) {
					onlineFriends.add( friend );
				}
			}
		}
		return onlineFriends;
	}
	
	/**
	 * Allows the User user to find new friends among the connected users
	 *
	 * @param user
	 * @param auth
	 * @return
	 */
	@Override
	public ArrayList< User > findFriends( User user, IAuthService auth ) throws RemoteException {
		ArrayList< User > futureFriends = new ArrayList<>();
		
		for ( int i = 1; i <= auth.getOnlineUsers().size(); i++ ) {
			futureFriends.add( auth.getOnlineUsers().get( i ) );
		}
		for ( User u : user.getFriends() ) {
			futureFriends.remove( u );
		}
		futureFriends.remove( user );
		System.out.println( "future friends" + futureFriends );
		return null;
	}
	
	/**
	 * Allows the User user to remove a friend exFriend from his friendlist
	 *
	 * @param user
	 * @param exFriend
	 * @return
	 */
	@Override
	public int removeFriend( User user, User exFriend ) throws RemoteException {
		if ( user.getFriends().remove( exFriend ) ) {
			return 0;
		} else {
			return -1;
		}
	}
	
	/**
	 * Allows the User user to send an friend invite to the User newFriend
	 *
	 * @param user
	 * @param newFriend
	 */
	@Override
	public void sendInvite( User user, User newFriend ) throws RemoteException {
		user.getFriendsRequest().put( user.getFriendsRequest().size() + 1, newFriend );
	}
	
	/**
	 * Allows the User user to add the User newFriend to his friendlist
	 *
	 * @param user
	 * @param newFriend
	 * @return
	 */
	@Override
	public int addFriend( User user, User newFriend ) throws RemoteException {
		if ( user.getFriends().add( newFriend ) ) {
			return 0;
		} else {
			return -1;
		}
	}
	
	
}