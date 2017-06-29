package ArchiChaT.Rest;

import ArchiChaT.Models.Message;
import ArchiChaT.Models.User;
import ArchiChaT.Server;
import ArchiChaT.Services.IMessageService;
import ArchiChaT.Services.IUserManagementService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
	public Message getOne( @PathParam( "id" ) int id ) throws RemoteException, NotBoundException {

		IMessageService messageService = (IMessageService) lookupService(Server.MESSAGE_SERVICE_NAME);
		return messageService.getOne(id);

	}

	//@Override
	@GET
	@Path( "{expID}/{destID}" )
	@Produces( MediaType.APPLICATION_JSON )
	public ArrayList<Message> getDmMessage( @PathParam( "expID" ) int expID, @PathParam( "destID" ) int destID) throws RemoteException, NotBoundException {
		IUserManagementService userManagementService = ( IUserManagementService ) lookupService( Server.USERMANAGEMENT_SERVICE_NAME );
		User expUser = userManagementService.find( expID );
		User destUser = userManagementService.find( destID );
		
		
		IMessageService messageService = (IMessageService) lookupService(Server.MESSAGE_SERVICE_NAME);
		return messageService.getDmMessage(expUser, destUser);

	}

	@Override
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public ArrayList< Message > getAll() throws RemoteException, NotBoundException {
		IMessageService messageService = (IMessageService) lookupService(Server.MESSAGE_SERVICE_NAME);
		return messageService.getAllMessage();
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
	public Message post( Message resource ) throws RemoteException, NotBoundException {
		IMessageService messageService = (IMessageService) lookupService(Server.MESSAGE_SERVICE_NAME);
		return messageService.getOne(messageService.saveMessage(resource));
	}
	
	@Override
	@DELETE
	@Path( "{id}" )
	public void delete( @PathParam( "id" ) int id ) {
	}

	@Override
	public Object lookupService(String serviceName) throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry( Server.HOST, Server.PORT );
		return registry.lookup( serviceName );
	}
}
