package ArchiChaT.Services;

import ArchiChaT.Models.Message;
import ArchiChaT.Models.User;

import java.util.ArrayList;

/**
 * Created by kevin on 31/05/2017.
 */
public interface IUserManagementService {

    public ArrayList<Message> findPreviousRecords(User user, AuthService auth);
    public ArrayList<User> findOnlineFriends(User user, AuthService auth);
    public ArrayList<User> findFriends(User user, AuthService auth);
    public int removeFriend(User user, User exFriend);
    public void sendInvite(User user, User newFriend);
    public int addFriend(User user, User newFriend);



}