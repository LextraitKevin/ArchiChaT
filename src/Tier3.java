import Services.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by SMITHE on 13-Jun-17.
 */
public class Tier3 {



	public static void main( String[] arg ) throws Exception {



		AuthService authService = new AuthService();
		MessageService messageService = new MessageService();
		PersistenceService persistenceService = new PersistenceService();
		UserManagementService userManagementService = new UserManagementService();

		Registry registry = LocateRegistry.createRegistry( Server.PORT );

		IAuthService stubAuth = ( IAuthService ) UnicastRemoteObject.exportObject( authService, 0 );
		registry.bind( Server.AUTH_SERVICE_NAME, stubAuth );

		IMessageService stubMsg = ( IMessageService ) UnicastRemoteObject.exportObject( messageService, 0 );
		registry.bind( Server.MESSAGE_SERVICE_NAME, stubMsg );


		IPersistenceService stubPers = ( IPersistenceService ) UnicastRemoteObject.exportObject( persistenceService, 0 );
		registry.bind( Server.PERSISTENCE_SERVICE_NAME, stubPers );

		IUserManagementService stubUserManag = ( IUserManagementService ) UnicastRemoteObject.exportObject( userManagementService, 0 );
		registry.bind( Server.USERMANAGEMENT_SERVICE_NAME, stubUserManag );
		boolean test=false;

		while (!test){

		}

		//System.out.println( authService.getOnlineUsers().toString() );
	}


}
