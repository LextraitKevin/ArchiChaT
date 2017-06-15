package ArchiChaT;

import ArchiChaT.Services.IAuthService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by SMITHE on 13-Jun-17.
 */
public class Client {
	public static void main( String[] arg ) throws Exception {
		Registry registry = LocateRegistry.getRegistry( Server.HOST, Server.PORT );
		IAuthService authService = ( IAuthService ) registry.lookup( Server.SERVICE_NAME );
		
		//authService.getOnlineUsers();
		
		System.out.println( authService.getOnlineUsers().toString() );
	}
}
