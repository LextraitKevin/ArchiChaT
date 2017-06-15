package ArchiChaT.Services;

import ArchiChaT.Models.Message;
import ArchiChaT.Models.User;

import java.util.ArrayList;

/**
 * Created by kevin on 13/06/2017.
 */
public class MessageService implements IMessageService {

	private static final String MESSAGE_FILENAME = "bin/saveMessage.txt";

	@Override
	public int saveMessage(Message m) {

		PersistenceService ps = new PersistenceService();

		ArrayList<Message> savedMessage = new ArrayList<Message>();

		// Deserialization

		Object tmp = ps.read(MESSAGE_FILENAME);

		if (tmp != null)
			savedMessage = (ArrayList<Message>) tmp;

		savedMessage.add(m);

		if (ps.write(MESSAGE_FILENAME, savedMessage)) {
			savedMessage.remove(m);
		}

		System.out.println("Message sauvegardé");
		return 0;
	}

	@Override
	public ArrayList<Message> getAllMessage() {

		PersistenceService ps = new PersistenceService();

		ArrayList<Message> savedMessage = new ArrayList<Message>();

		Object tmp = ps.read(MESSAGE_FILENAME);

		if (tmp != null)
			savedMessage = (ArrayList<Message>) tmp;

		return savedMessage;
	}

	@Override
	public ArrayList<Message> getDmMessage(User author, User receipUser) {
		PersistenceService ps = new PersistenceService();

		ArrayList<Message> savedMessage = new ArrayList<Message>();

		ArrayList<Message> conversation = new ArrayList<Message>();

		Object tmp = ps.read(MESSAGE_FILENAME);

		if (tmp != null)
			savedMessage = (ArrayList<Message>) tmp;


		for (Message m:
				savedMessage) {
			if(m.getAuthor().getId()==author.getId() && m.getReceipUser().getId()== receipUser.getId()){
				conversation.add(m);
			}
		}

		return conversation;
	}
}
