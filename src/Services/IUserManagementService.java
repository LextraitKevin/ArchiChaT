package Services;

import Models.Message;
import Models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 31/05/2017.
 */
public interface IUserManagementService extends Remote {

    public ArrayList<Message> findPreviousRecords(User user, AuthService auth) throws RemoteException;
    public ArrayList<User> findOnlineFriends(User user, AuthService auth)throws RemoteException;
    public ArrayList<User> findFriends(User user, AuthService auth)throws RemoteException;
    public int removeFriend(User user, User exFriend)throws RemoteException;
    public void sendInvite(User user, User newFriend)throws RemoteException;
    public int addFriend(User user, User newFriend)throws RemoteException;



}