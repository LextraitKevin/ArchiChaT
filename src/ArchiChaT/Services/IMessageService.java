package ArchiChaT.Services;

import ArchiChaT.Models.Message;
import ArchiChaT.Models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 13/06/2017.
 */
public interface IMessageService extends Remote {

	public int saveMessage(Message msg) throws RemoteException;

	public ArrayList<Message> getAllMessage() throws RemoteException;

	public ArrayList<Message> getDmMessage(User author, User receipUser) throws RemoteException;

	public Message getOne(int id) throws RemoteException;
}
