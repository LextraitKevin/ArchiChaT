package ArchiChaT;

import ArchiChaT.Models.User;
import ArchiChaT.Rest.RestMessage;
import ArchiChaT.Rest.RestUser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import ArchiChaT.Services.IAuthService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by SMITHE on 13-Jun-17.
 */
public class Client {
	public static void main( String[] arg ) throws Exception {

		RestMessage rm = new RestMessage();
		RestUser ru = new RestUser();

		Scanner sc = new Scanner(System.in);

		System.out.println("Saisissez une action : ");

		String action = sc.nextLine();

		switch (action){

			case "ca":
				System.out.println("Saisissez un pseudo : ");
				String pseudo = sc.nextLine();

				System.out.println("Saisissez un mot de passe : ");
				String password = sc.nextLine();

				User user= new User(1,pseudo,password);

				ru.post(user);

				URL url = new URL("http://example.com");
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				break;
				



		}




		/*
		Registry registry = LocateRegistry.getRegistry( Server.HOST, Server.PORT );
		IAuthService authService = ( IAuthService ) registry.lookup( Server.SERVICE_NAME );
		
		//authService.getOnlineUsers();
		
		System.out.println( authService.getOnlineUsers().toString() );*/
	}


}
