package remote;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import beans.Client;

@Remote
public interface ClientManagerRemote {

    public void create( Client client );

    public void remove( long ID );

    public void remove( Client client );

    public List<Client> find( Map<String, String> tabProps );

}
