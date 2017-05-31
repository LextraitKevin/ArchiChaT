package Services;

import Models.User;

/**
 * Created by kevin on 31/05/2017.
 */
public interface IAuthService {

    public int connection (User user);
    public int register (User user);
    public void logout(int userId);
}
