package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanSession.User;
import beans.Client;
import builders.UserBuilder;
import remote.ClientManagerRemote;
import remote.EncryptorRemote;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet( "/Connexion" )
public class ConnexionServlet extends HttpServlet {

    /**
     * 
     */

    private static final String ATT_USERSESSION  = "userSession";
    private static final String ATT_ERREURS      = "formUser";
    private static final String ATT_CLIENT       = "client";

    private static final String VUE_ECHEC        = "/WEB-INF/inscription.jsp";
    private static final String VUE_SUCCES       = "/WEB-INF/connexionValid.jsp";

    private User                user;
    private UserBuilder         userBuilder;

    @EJB
    ClientManagerRemote         clientManagerRemote;
    @EJB
    EncryptorRemote             encryptorRemote;

    private Client              client;

    private static final long   serialVersionUID = -3976021118683231696L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        userBuilder = new UserBuilder();

        client = clientManagerRemote.getClientFromEmail(
                request.getParameter( UserBuilder.CHAMP_EMAIL ) );
        user = userBuilder.createUser( request, client, encryptorRemote );

        if ( userBuilder.getErreurs().isEmpty() ) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute( ATT_USERSESSION, user );
            request.setAttribute( ATT_ERREURS, userBuilder );
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward(
                    request, response );

        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append( request.getContextPath() ).append( VUE_ECHEC );

            client = new Client();
            client.setEmail( request.getParameter( UserBuilder.CHAMP_EMAIL ) );

            request.setAttribute( ATT_CLIENT, client );
            this.getServletContext().getRequestDispatcher( VUE_ECHEC ).forward( request, response );
        }
    }

}
