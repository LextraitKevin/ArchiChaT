/**
 * Created by kevin on 10/05/2017.
 */

import Models.Message;
import Models.User;
import Services.AuthService;
import Services.MessageService;
import Services.PersistenceService;
import Services.UserManagementService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

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



		MessageService msgS = new MessageService();

		UserManagementService UMS = new UserManagementService();
		AuthService authS = new AuthService();

		authS.register(newuser);
		authS.register(newuser1);

		Message m1 = new Message(1,newuser,"je suis l'utilisateur 1",newuser1);

		msgS.saveMessage(m1);


		Message m2 = new Message(2,newuser1,"je suis l'utilisateur 2",newuser);
		msgS.saveMessage(m2);
		Message m3 = new Message(3,newuser,"coucouc",newuser1);
		msgS.saveMessage(m3);
		Message m4 = new Message(4,newuser1,"hey",newuser);
		msgS.saveMessage(m4);


		ArrayList<Message> test = msgS.getDmMessage(newuser,newuser1);

		for (Message m:
			 test) {
			System.out.println(m);
		}






	}
}

