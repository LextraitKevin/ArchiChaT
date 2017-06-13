/**
 * Created by kevin on 10/05/2017.
 */

import Models.User;
import Services.AuthService;
import Services.IAuthService;
import Services.UserManagementService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	public static final String HOST = "127.0.0.1";
	public static final int PORT = 3000;
	public static final String SERVICE_NAME = "ArchiChaTSrv";
	
	public static void main( String[] args ) throws Exception {
		AuthService authService = new AuthService();
		
		IAuthService IAuthSvc = ( IAuthService ) UnicastRemoteObject.exportObject( authService, 0 );
		Registry registry = LocateRegistry.createRegistry( PORT );
		registry.bind( SERVICE_NAME, IAuthSvc );
		
		/*//authService.start();
		
		/*AuthService stub;
		stub = ( AuthService ) UnicastRemoteObject.exportObject( authService, 0 );
		
		Registry registry = LocateRegistry.createRegistry( 2001 );
		registry.bind( "Infotrafic", stub );
		
		System.out.println( "Serveur ok" );
		
		// Test
		User newuser = new User( 1, "toto", "passwordtoto" );
		User newuser1 = new User( 2, "tutu", "ghbsdk" );
		
		UserManagementService UMS = new UserManagementService();
		AuthService authS = new AuthService();
		
		authS.register( newuser );
		authS.register( newuser1 );
		
		newuser.setPassword( "bla" );
		
		authS.login( newuser );*/
		

		
	}
}

