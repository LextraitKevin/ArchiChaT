package ArchiChaT;

import ArchiChaT.Models.User;
import ArchiChaT.Rest.RestMessage;
import ArchiChaT.Rest.RestUser;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import ArchiChaT.Services.IAuthService;
import com.google.gson.Gson;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by SMITHE on 13-Jun-17.
 */
public class Client {
	public static void main( String[] arg ) throws Exception {


		Gson gson = new Gson();

		boolean life=true;


		Scanner sc = new Scanner(System.in);



		while (life) {

			System.out.println("Saisissez une action : ");
			System.out.println("ca : modifier son compte \n" +
					"quit : quitter l'application");

			String action = sc.nextLine();

			switch (action) {

				case "ca":
					System.out.println("Saisissez un pseudo : ");
					String pseudo = sc.nextLine();

					System.out.println("Saisissez un mot de passe : ");
					String password = sc.nextLine();

					User user = new User(1, pseudo, password);

					String json = gson.toJson(user);

					System.out.println(httpRequest("http://localhost:8080/ArchiChaT_Web_exploded/users/"+user.getId(), "PUT", json));

					break;

				case "quit":
					life=false;
					break;

			}
		}

	}



	private static String httpRequest(String urlHTTP, String type, String jsonContent) throws IOException {

		URL url = new URL(urlHTTP);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod(type);
		con.setDoOutput(true);
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept", "application/json");

		OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
		osw.write(jsonContent);
		osw.flush();
		osw.close();
		return con.getResponseMessage();
	}


}
