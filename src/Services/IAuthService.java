package Services;

import Models.User;
import java.util.HashMap;

/**
 * Created by kevin on 31/05/2017.
 */
public interface IAuthService {

	public int login(User user);

	public int register(User user);

	public void logout(User user);

	public HashMap<Integer,User> getOnlineUsers();
}
