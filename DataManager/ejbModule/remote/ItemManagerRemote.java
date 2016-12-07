package remote;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import beans.Item;

@Remote
public interface ItemManagerRemote {

    public void create( Item item );

    public void remove( Item item );

    public void remove( long ID );

    public List<Item> find( Map<String, String> tabProps );

}
