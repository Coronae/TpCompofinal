package remote;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import beans.Command;

@Remote
public interface CommandManagerRemote {

    public void create( Command command );

    public void remove( Command command );

    public void remove( long ID );

    public List<Command> find( Map<String, String> tabProps );

}
