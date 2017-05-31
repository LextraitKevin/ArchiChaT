package Services;

import Models.Message;
import Models.User;

import java.util.ArrayList;

/**
 * Created by kevin on 31/05/2017.
 */
public class UserManagementService implements IUserManagementService{

    @Override
    public ArrayList<Message> findPreviousRecords(User user) {
        return null;
    }

    @Override
    public ArrayList<User> findOnlineUsers() {
        return null;
    }

    @Override
    public ArrayList<User> findFriends(User user) {
        return null;
    }

    @Override
    public int removeFriend(User user, User exFriend) {
        return 0;
    }

    @Override
    public void sendInvite(User user, User newFriend) {

    }
}
