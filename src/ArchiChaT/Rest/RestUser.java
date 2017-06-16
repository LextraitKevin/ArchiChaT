package ArchiChaT.Rest;

import ArchiChaT.Models.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Created by SMITHE on 14-Jun-17.
 */

@Path( "/users" )
public class RestUser implements IRest< User > {
	
	/**
	 * Get one User from file with userID
	 * @param id user id
	 * @return User match to userID
	 */
	@Override
	@GET
	@Path( "{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public User getOne( @PathParam( "id" ) int id ) {
		// TODO Get from file
		User user = new User( 1, "toto", "passwordtoto" );
		
		return user;
	}
	
	/**
	 * Get all users
	 * @return All users
	 */
	@Override
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public ArrayList< User > getAll() {
		ArrayList< User > users = new ArrayList<>();
		
		// TODO Get from file
		users.add( new User( 1, "toto", "passwordtoto" ) );
		
		return users;
	}
	
	/**
	 * Update fully User
	 * @param id User id to update
	 * @param resource User pass by client
	 * @return User saved
	 */
	@Override
	@PUT
	@Path( "{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	@Consumes( MediaType.APPLICATION_JSON )
	public User put( @PathParam( "id" ) int id, User resource ) {
		// TODO Update file
		
		return resource;
	}
	
	/**
	 * Add user
	 * @param resource User to add
	 * @return User added
	 */
	@Override
	@POST
	@Produces( MediaType.APPLICATION_JSON )
	@Consumes( MediaType.APPLICATION_JSON )
	public User post( User resource ) {
		// TODO Update file
		
		return resource;
	}
	
	/**
	 * Delete user
	 * @param id User ID to delete
	 */
	@Override
	@DELETE
	@Path( "{id}" )
	public void delete( @PathParam( "id" ) int id ) {
		// TODO Delete on file
	}
}
