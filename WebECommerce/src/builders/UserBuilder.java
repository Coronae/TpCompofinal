package builders;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import beanSession.User;
import beans.Client;
import remote.EncryptorRemote;

public class UserBuilder {

    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASS  = "motdepasse";

    @EJB
    private EncryptorRemote     encryptorRemote;

    private Map<String, String> erreurs     = new HashMap<String, String>();

    public User inscrireUser( HttpServletRequest request, Client client ) {
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String pwd = encryptorRemote.encrypt( getValeurChamp( request, CHAMP_PASS ) );

        User user = new User();

        try {
            validationEmail( email, client.getEmail() );
            user.setEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }

        try {
            validationMotDePasse( pwd, client.getPassword() );
            user.setPWD( pwd );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );

        }

        return user;
    }

    private void validationEmail( String email, String clientEmail ) throws Exception {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

    private void validationMotDePasse( String pwd, String clientPwd ) throws Exception {
        if ( pwd != null && clientPwd != null ) {
            if ( !pwd.equals( clientPwd ) )
                throw new Exception( "Mauvais mot de passe." );

        } else {
            throw new Exception( "Merci de renseigner un mot de passe." );
        }
    }

    /*
     * Ajoute un message correspondant au champ sp�cifi� � la map des erreurs.
     */

    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }

    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

}
