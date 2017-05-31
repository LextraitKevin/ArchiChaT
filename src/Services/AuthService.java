package Services;

import Models.User;

/**
 * Created by kevin on 31/05/2017.
 */
public class AuthService implements IAuthService {


    @Override
    public int connection(User user) {
        return 0;
    }

    @Override
    public int register(User user) {
        return 0;
    }

    @Override
    public void logout(int userId) {

    }
}

