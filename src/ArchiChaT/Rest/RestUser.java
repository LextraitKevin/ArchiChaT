package ArchiChaT.Rest;

import ArchiChaT.Models.User;
import ArchiChaT.Server;
import ArchiChaT.Services.IAuthService;
import ArchiChaT.Services.IUserManagementService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by SMITHE on 14-Jun-17.
 */

@Path( "/users" )
public class RestUser implements IRest< User > {
	/**
	 * @param serviceName
	 * @return
	 */
	@Override
	public Object lookupService( String serviceName ) throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry( Server.HOST, Server.PORT );
		return registry.lookup( serviceName );
	}
	
	/**
	 * Get one User from file with userID
	 *
	 * @param id user id
	 * @return User match to userID
	 */
	@Override
	@GET
	@Path( "{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public User getOne( @PathParam( "id" ) int id ) throws RemoteException, NotBoundException {
		IUserManagementService userManagementService = ( IUserManagementService ) lookupService( Server.USERMANAGEMENT_SERVICE_NAME );
		//System.out.println( id );
		return userManagementService.find( id );
	}
	
	/**
	 * Get all online User
	 *
	 * @return onlineUsers
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	@GET
	@Path( "onlineUser" )
	@Produces( MediaType.APPLICATION_JSON )
	public HashMap<Integer, User> getUserFriends() throws RemoteException, NotBoundException {
		IAuthService authService = (IAuthService) lookupService( Server.AUTH_SERVICE_NAME );
		
		return authService.getOnlineUsers();
	}
	
	/**
	 * Get all users
	 *
	 * @return All users
	 */
	@Override
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public ArrayList< User > getAll() throws RemoteException, NotBoundException {
		//ArrayList< User > users = new ArrayList<>();
		IUserManagementService userManagementService = ( IUserManagementService ) lookupService( Server.USERMANAGEMENT_SERVICE_NAME );
		
		return userManagementService.findAll();
	}
	
	/**
	 * Update fully User
	 *
	 * @param id       User id to update
	 * @param resource User pass by client
	 * @return User saved
	 */
	@Override
	@PUT
	@Path( "{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	@Consumes( MediaType.APPLICATION_JSON )
	public User put( @PathParam( "id" ) int id, User resource ) throws RemoteException, NotBoundException {
		IUserManagementService userManagementService = ( IUserManagementService ) lookupService( Server.USERMANAGEMENT_SERVICE_NAME );
		User currentUser = userManagementService.find( id );
		currentUser.setName( resource.getName() );
		currentUser.setPassword( resource.getPassword() );
		currentUser.setFriends( resource.getFriends() );
		currentUser.setFriendsRequest( resource.getFriendsRequest() );
		
		return userManagementService.update( currentUser );
	}
	
	/**
	 * Add user
	 *
	 * @param resource User to add
	 * @return User added
	 */
	@Override
	@POST
	@Produces( MediaType.APPLICATION_JSON )
	@Consumes( MediaType.APPLICATION_JSON )
	public User post( User resource ) throws RemoteException, NotBoundException {
		IUserManagementService userManagementService = ( IUserManagementService ) lookupService( Server.USERMANAGEMENT_SERVICE_NAME );
		return userManagementService.update( resource );
	}
	
	/**
	 * Delete user
	 *
	 * @param id User ID to delete
	 */
	@Override
	@DELETE
	@Path( "{id}" )
	public void delete( @PathParam( "id" ) int id ) throws RemoteException, NotBoundException {
		IUserManagementService userManagementService = ( IUserManagementService ) lookupService( Server.USERMANAGEMENT_SERVICE_NAME );
		userManagementService.delete( id );
	}
}
