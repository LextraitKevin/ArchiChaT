package Services;

import Models.Message;
import Models.User;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kevin on 31/05/2017.
 */
public class UserManagementService implements IUserManagementService{

    @Override
    //TODO
    public ArrayList<Message> findPreviousRecords(User user, AuthService auth) {

        return null;
    }


    /**
     * Returns the User user's online friends
     * @param user
     * @param auth
     * @return
     */
    @Override
    public ArrayList<User> findOnlineFriends(User user, AuthService auth) {
        ArrayList<User> onlineFriends = new ArrayList<>();
        for(User friend : user.getFriends()) {
            for (int i = 1; i <= auth.getOnlineUsers().size(); i++) {
                if (auth.getOnlineUsers().get(i).getId() == friend.getId()) {
                    onlineFriends.add(friend);
                }
            }
        }
        return onlineFriends;
    }

    /**
     * Allows the User user to find new friends among the connected users
     * @param user
     * @return
     */
    @Override
    public ArrayList<User> findFriends(User user, AuthService auth) {
        ArrayList<User> futureFriends = new ArrayList<>();

        for (int i = 1; i <= auth.getOnlineUsers().size(); i++) {
            futureFriends.add(auth.getOnlineUsers().get(i));
        }
        for (User u : user.getFriends()){
            futureFriends.remove(u);
        }
        futureFriends.remove(user);
        System.out.println("future friends" + futureFriends);
        return null;
    }

    /**
     * Allows the User user to remove a friend exFriend from his friendlist
     * @param user
     * @param exFriend
     * @return
     */
    @Override
    public int removeFriend(User user, User exFriend) {
        if(user.getFriends().remove(exFriend)){
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * Allows the User user to send an friend invite to the User newFriend
     * @param user
     * @param newFriend
     */
    @Override
    public void sendInvite(User user, User newFriend) {
        user.getFriendsRequest().put(user.getFriendsRequest().size()+1,newFriend);
    }

    /**
     * Allows the User user to add the User newFriend to his friendlist
     * @param user
     * @param newFriend
     * @return
     */
    @Override
    public int addFriend(User user, User newFriend) {
        if(user.getFriends().add(newFriend)){
            return 0;
        } else {
            return -1;
        }
    }


}