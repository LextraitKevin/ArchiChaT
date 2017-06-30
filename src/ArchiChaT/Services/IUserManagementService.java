package ArchiChaT.Services;

import ArchiChaT.Models.Message;
import ArchiChaT.Models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 31/05/2017.
 */
public interface IUserManagementService extends Remote {

    public ArrayList<Message> findPreviousRecords(User user, AuthService auth) throws RemoteException;
    public ArrayList<User> findOnlineFriends(User user, AuthService auth)throws RemoteException;
    public ArrayList<User> findFriends( User user, IAuthService auth)throws RemoteException;
    public User update( User user ) throws RemoteException;
    public void delete( int uID ) throws RemoteException;
    public int removeFriend(User user, User exFriend)throws RemoteException;
    public void sendInvite(User user, User newFriend)throws RemoteException;
    public int addFriend(User user, User newFriend)throws RemoteException;
    public User find(int uId) throws RemoteException;
    public ArrayList<User> findAll() throws RemoteException;



}