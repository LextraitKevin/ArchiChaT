package ArchiChaT;

import ArchiChaT.Models.Message;
import ArchiChaT.Models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ArchiChaT.Services.AuthService;
import ArchiChaT.Services.IAuthService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.lang.reflect.Type;


/**
 * Created by SMITHE on 13-Jun-17.
 */
public class Client {
	public static void main( String[] arg ) throws Exception {


		Gson gson = new Gson();

		boolean life=true;
		boolean connected=false;


		Scanner sc = new Scanner(System.in);

		String pseudo ="";
		String password ="";
		User currentUser= null;



		while (life) {

			System.out.println("Saisissez une action : ");

			if (connected == false) {


				System.out.println("quit : quitter l'application \n" +
						"connexion : connexion au compte");
			}else{
				System.out.println("update : modifier son compte \n"+
						"addFriend : Ajouter un ami pour discuter\n"+
						"onlineFriend : voir mes amis connectes\n"+
						"sendMsg : Envoyer un message à un ami"
				);
			}

			String action = sc.nextLine();


			switch (action) {

				case "sendMsg":

					if(connected) {

						System.out.println("Saisissez l'identifiant de votre ami : ");
						String id = sc.nextLine();

						System.out.println("Saisissez votre message : ");
						String contentMSG = sc.nextLine();

						String content = sendGet("http://localhost:8080/ArchiChaT_Web_exploded/users/"+ id);

						User destinataire = new Gson().fromJson(content,User.class);

						Message msg = new Message(1,currentUser,contentMSG,destinataire);

						String json = gson.toJson(msg);


						System.out.println(httpRequest("http://localhost:8080/ArchiChaT_Web_exploded/messages/", "POST", json));

					}else{
						System.out.println("You must be connected to do this action");
					}


					break;


				case "addFriend" :

					if(connected) {


						System.out.println("Saisissez l'identifiant de votre ami : ");


						String idFriend = sc.nextLine();

						ArrayList<User> oldFriend = currentUser.getFriends();

						String content = sendGet("http://localhost:8080/ArchiChaT_Web_exploded/users/"+ idFriend);

						User friend = new Gson().fromJson(content,User.class);

						oldFriend.add(friend);

						currentUser.setFriends(oldFriend);

						String json = gson.toJson(currentUser);

						System.out.println(httpRequest("http://localhost:8080/ArchiChaT_Web_exploded/users/" + currentUser.getId(), "PUT", json));
					}else{
						System.out.println("You must be connected to do this action");
					}

					break;

				case "update":
					if(connected) {
						System.out.println("Saisissez un pseudo : ");
						pseudo = sc.nextLine();

						System.out.println("Saisissez un mot de passe : ");
						password = sc.nextLine();

						User user = new User(1, pseudo, password);

						String json = gson.toJson(user);

						System.out.println(httpRequest("http://localhost:8080/ArchiChaT_Web_exploded/users/" + user.getId(), "PUT", json));
					}else{
						System.out.println("You must be connected to do this action");
					}

					break;

				case "connexion" :

					if(connected) {

						System.out.println("You are already connected");

					}else {
						System.out.println("Saisissez un pseudo : ");
						pseudo = sc.nextLine();

						System.out.println("Saisissez un mot de passe : ");
						password = sc.nextLine();

						String content = sendGet("http://localhost:8080/ArchiChaT_Web_exploded/users");

						Type listType = new TypeToken<ArrayList<User>>() {
						}.getType();

						List<User> yourClassList = new Gson().fromJson(content, listType);

						for (User u : yourClassList) {

							if (u.getPassword().equals(password) && u.getName().equals(pseudo)) {
								currentUser=u;
								connected = true;

							}
						}

						System.out.println(connected);
					}

					break;

				case "quit":
					System.out.println("See you soon my friend");
					life=false;
					break;

			}
		}

	}



	private static String httpRequest(String urlHTTP, String type, String jsonContent ) throws IOException {

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

	private static String sendGet(String url) throws Exception {


		Gson gson = new Gson();


		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		return response.toString();

	}


}
