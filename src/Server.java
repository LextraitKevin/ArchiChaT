/**
 * Created by kevin on 10/05/2017.
 */

import Models.User;
import Services.AuthService;
import Services.UserManagementService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	public static void main(String[] args) throws Exception {
/*
	AuthService authService = new AuthService();
        //authService.start();

        AuthService stub;
        stub = (AuthService) UnicastRemoteObject.exportObject(authService,0);

        Registry registry = LocateRegistry.createRegistry(2001);
        registry.bind("Infotrafic", stub);

        System.out.println("Serveur ok");*/

		User newuser = new User(1, "toto", "passwordtoto");
		User newuser1 = new User(2, "tutu", "ghbsdk");

		UserManagementService UMS = new UserManagementService();
		AuthService authS = new AuthService();

		authS.register(newuser);
		authS.register(newuser1);

		//newuser.setPassword("bla");

		//authS.login(newuser1);

	}
}

