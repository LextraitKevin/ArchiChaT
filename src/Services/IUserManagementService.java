package Services;

import Models.Message;
import Models.User;

import java.util.ArrayList;

/**
 * Created by kevin on 31/05/2017.
 */
public interface IUserManagementService {

    public ArrayList<Message> findPreviousRecords(User user);
    public ArrayList<User> findOnlineUsers();
    public ArrayList<User> findFriends(User user);
    public int removeFriend(User user, User exFriend);
    public void sendInvite(User user, User newFriend);



}
