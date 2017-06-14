/**
 * Created by kevin on 10/05/2017.
 */

import Models.Message;
import Models.User;
import Services.AuthService;
import Services.MessageService;
import Services.IAuthService;
import Services.UserManagementService;
import java.util.ArrayList;

public class Server {

	public static final String HOST = "127.0.0.1";
	public static final int PORT = 3000;
	public static final String SERVICE_NAME = "ArchiChaTSrv";


	public static void main(String[] args) throws Exception {

/*
		AuthService authService = new AuthService();

		IAuthService IAuthSvc = ( IAuthService ) UnicastRemoteObject.exportObject( authService, 0 );
		Registry registry = LocateRegistry.createRegistry( PORT );
		registry.bind( SERVICE_NAME, IAuthSvc );*/

		User newuser = new User(1, "toto", "passwordtoto");
		User newuser1 = new User(2, "tutu", "ghbsdk");
		User newuser2 = new User(2, "tutu", "ghbsdk");



		MessageService msgS = new MessageService();

		UserManagementService UMS = new UserManagementService();
		AuthService authS = new AuthService();

		authS.register(newuser);
		authS.register(newuser1);
		authS.register(newuser2);

		//On ajoute un ami à newuser
		ArrayList<User> newuserFriends = new ArrayList<>();
		newuserFriends.add(newuser1);

		newuser.setFriends(newuserFriends);
		authS.login(newuser);
		authS.login(newuser1);
		authS.login(newuser2);

		System.out.println(UMS.findFriends(newuser, authS));

		Message m1 = new Message(1,newuser,"je suis l'utilisateur 1",newuser1);

		msgS.saveMessage(m1);


		Message m2 = new Message(2,newuser1,"je suis l'utilisateur 2",newuser);
		msgS.saveMessage(m2);
		Message m3 = new Message(3,newuser,"coucouc",newuser1);
		msgS.saveMessage(m3);
		Message m4 = new Message(4,newuser1,"hey",newuser);
		msgS.saveMessage(m4);


		ArrayList<Message> test = msgS.getDmMessage(newuser,newuser1);


		authS.login(newuser);

		for (Message m:
				test) {
			System.out.println(m);
		}


	}
}