package builders;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import beans.Client;
import beans.Command;
import beans.Item;
import remote.MoneyManagerRemote;

public class CommandBuilder {

    @EJB
    private MoneyManagerRemote  money;

    private static final String CHAMP_LISTITEMS = "listItemClient";
    // private static final String CHAMP_CURRENCY = "currencyClient";
    // private static final String CHAMP_TOCURRENCY = "toCurrencyClient";

    public CommandBuilder() {
        // TODO Auto-generated constructor stub
    }

    public Command createCommand( HttpServletRequest request, Client client ) {

        Set<Item> listItem = (Set<Item>) request.getAttribute( CHAMP_LISTITEMS );

        Command c = new Command();

        c.setClient( client );
        c.setDate( new Timestamp( System.currentTimeMillis() ) );
        c.setEnCours( true );
        c.setPrixHT( calculPrixHT( listItem ) );
        c.setPrixTTC( calculPrixTTC( listItem ) );
        c.setListItems( listItem );

        return c;
    }

    private double calculPrixHT( Set<Item> listItem ) {
        double prixHT = 0;

        for ( Item i : listItem ) {
            prixHT += i.getPrixHT();// a modifier par la suite pour autre devise
                                    // que fr
        }
        return prixHT;
    }

    private double calculPrixTTC( Set<Item> listItem ) {
        double prixTTC = 0;

        for ( Iterator<Item> i = listItem.iterator(); i.hasNext(); ) {
            Item item = i.next();
            prixTTC += money.calculTTCFrance( item.getPrixHT(), item.getCategorie() );
        }
        return prixTTC;
    }

}