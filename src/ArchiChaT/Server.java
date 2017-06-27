/**
 * Created by kevin on 10/05/2017.
 */

package ArchiChaT;


import ArchiChaT.Rest.RestMessage;
import ArchiChaT.Rest.RestUser;

import javax.jws.WebService;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@WebService( name = "ArchiChaT" )
@ApplicationPath( "/" )
public class Server extends Application {
	
	public static final String HOST = "127.0.0.1";
	public static final int PORT = 3000;
	
	public static final String AUTH_SERVICE_NAME = "AuthService";
	public static final String MESSAGE_SERVICE_NAME = "MessageService";
	public static final String PERSISTENCE_SERVICE_NAME = "PersistenceService";
	public static final String USERMANAGEMENT_SERVICE_NAME = "UserManagementService";

	/*private static IAuthService authService;
	private static IPersistenceService persistenceService;
	private static IMessageService messageService;
	private static IUserManagementService userManagementService;*/
	
	
	/**
	 * Set the resources include in server
	 *
	 * @return All resources classes in Server
	 */
	public Set< Class< ? > > getClasses() {
		HashSet resourcesREST = new HashSet< Class< ? > >();
		
		// Add below
		resourcesREST.add( RestMessage.class );
		resourcesREST.add( RestUser.class );
		return resourcesREST;
	}


	/*public static void main(String[] args) throws Exception {



		Registry registry = LocateRegistry.getRegistry( Server.HOST, Server.PORT );
		authService = ( IAuthService ) registry.lookup( Server.AUTH_SERVICE_NAME );
		messageService = ( IMessageService ) registry.lookup( Server.MESSAGE_SERVICE_NAME );
		persistenceService = ( IPersistenceService ) registry.lookup( Server.PERSISTENCE_SERVICE_NAME );
		userManagementService = ( IUserManagementService ) registry.lookup( Server.USERMANAGEMENT_SERVICE_NAME );



		User newuser = new User(1, "toto", "passwordtoto");

		authService.register(newuser);

		System.out.println(authService.login(newuser));




*//*

		User newuser = new User(1, "toto", "passwordtoto");
		User newuser1 = new User(2, "tutu", "ghbsdk");
		User newuser2 = new User(3, "tutu", "ghbsdk");



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
		}*//*


	}*/
}