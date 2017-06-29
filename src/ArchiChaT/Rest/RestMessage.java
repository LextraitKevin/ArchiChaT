package ArchiChaT.Rest;

import ArchiChaT.Models.Message;
import ArchiChaT.Models.User;
import ArchiChaT.Server;
import ArchiChaT.Services.IMessageService;

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
	public Message getOne( int id ) throws RemoteException, NotBoundException {

		IMessageService messageService = (IMessageService) lookupService(Server.MESSAGE_SERVICE_NAME);
		return messageService.getOne(id);

	}

	//@Override
	@GET
	@Path( "{exp}/{dest}" )
	@Produces( MediaType.APPLICATION_JSON )
	public ArrayList<Message> getDmMessage(User exp, User dest) throws RemoteException, NotBoundException {

		IMessageService messageService = (IMessageService) lookupService(Server.MESSAGE_SERVICE_NAME);
		return messageService.getDmMessage(exp, dest);

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
		Registry registry = LocateRegistry.getRegistry( Server.HOST, Server.PORT );
		return registry.lookup( serviceName );
	}
}
