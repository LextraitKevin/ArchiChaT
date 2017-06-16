package ArchiChaT.Rest;

import ArchiChaT.Models.Message;
import ArchiChaT.Models.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by SMITHE on 14-Jun-17.
 */

@Path( "/messages" )
public class RestMessage implements IRest< Message > {
	
	@Override
	@GET
	@Path( "{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Message getOne( int id ) {
		// TODO Get from file
		
		User user1 = new User( 1, "toto", "passwordtoto" );
		User user2 = new User( 2, "tutu", "ghbsdk" );
		Message m1 = new Message( 1, user1, "je suis l'utilisateur 1", user2 );
		
		return m1;
	}
	
	@Override
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public ArrayList< Message > getAll() {
		ArrayList< Message > messages = new ArrayList<>();
		
		// TODO Get from file
		
		User user1 = new User( 1, "toto", "passwordtoto" );
		User user2 = new User( 2, "tutu", "ghbsdk" );
		Message m1 = new Message( 1, user1, "je suis l'utilisateur 1", user2 );
		
		messages.add( m1 );
		
		return messages;
	}
	
	@Override
	@PUT
	@Path( "{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	@Consumes( MediaType.APPLICATION_JSON )
	public Message put( @PathParam( "id" ) int id, Message resource ) {
		// TODO Update file
		
		return resource;
	}
	
	@Override
	@POST
	@Produces( MediaType.APPLICATION_JSON )
	@Consumes( MediaType.APPLICATION_JSON )
	public Message post( Message resource ) {
		// TODO Update file
		
		return resource;
	}
	
	@Override
	@DELETE
	@Path( "{id}" )
	public void delete( @PathParam( "id" ) int id ) {
		// TODO Delete on file
	}

	@Override
	public Object lookupService(String serviceName) throws RemoteException, NotBoundException {
		return null;
	}
}
