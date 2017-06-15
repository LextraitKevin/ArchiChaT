package ArchiChaT.Services;



/**
 * Created by kevin on 31/05/2017.
 */
public interface IPersistenceService {

	public Object read(String filename);
	public boolean write(String filename,Object content);

}
