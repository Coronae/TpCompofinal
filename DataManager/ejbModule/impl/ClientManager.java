package impl;

import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import beans.Client;
import remote.ClientManagerRemote;

@Stateless
@LocalBean
public class ClientManager implements ClientManagerRemote {

    final static String SELECT_QUERY = "SELECT c FROM CLIENTS as ";

    @PersistenceContext( unitName = "BD_ECommerce" )
    EntityManager       em;

    @Override
    public void create( Client client ) {
        try {
            em.persist( client );
        } catch ( Exception e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void remove( Client client ) {
        try {
            em.remove( em.merge( client ) );
        } catch ( Exception e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public Client getClientFromEmail( String email ) {
        StringBuilder sbQuery = new StringBuilder( SELECT_QUERY );
        Query query;
        Client client = null;
        if ( email != null ) {
            try {
                query = em.createQuery( sbQuery.append( "c.email = " ).append( email ).toString() );
                client = (Client) query.getSingleResult();
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return client;
    }

    @Override
    public void remove( long ID ) {
        StringBuilder sbQuery = new StringBuilder( SELECT_QUERY );
        Query query = em.createQuery( sbQuery.append( "c.ID = " ).append( ID ).toString() );
        Client client = (Client) query.getSingleResult();
        try {
            em.remove( em.merge( client ) );
        } catch ( Exception e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public List<Client> find( Map<String, String> tabProps ) {
        // TODO Auto-generated method stub
        return null;
    }

}
