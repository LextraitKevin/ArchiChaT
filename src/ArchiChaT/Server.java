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
}