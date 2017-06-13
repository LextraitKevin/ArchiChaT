package Services;

import Models.Message;
import Models.User;

import java.util.ArrayList;

/**
 * Created by kevin on 13/06/2017.
 */
public interface IMessageService {

	public int saveMessage(Message msg);

	public ArrayList<Message> getAllMessage();

	public ArrayList<Message> getDmMessage(User author, User receipUser);
}
