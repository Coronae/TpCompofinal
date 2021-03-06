package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Client;
import builders.ClientBuilder;
import remote.ClientManagerRemote;
import remote.EncryptorRemote;

@WebServlet( name = "InscriptionServlet", urlPatterns = "/Inscription" )
public class InscriptionServlet extends HttpServlet {

    private static final long   serialVersionUID = -4857785590381026466L;
    private static final String ATT_CLIENT       = "client";
    private static final String ATT_ERREURS      = "form";

    private static final String VUE_FORM         = "/WEB-INF/inscription.jsp";
    private static final String VUE_SUCCES       = "/WEB-INF/inscriptionValid.jsp";

    private Client              client;

    private ClientBuilder       clientBuilder;

    @EJB
    private ClientManagerRemote clientManagerRemote;
    @EJB
    private EncryptorRemote     encryptorRemote;

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );

    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        clientBuilder = new ClientBuilder();
        client = clientBuilder.createClient( request, encryptorRemote );

        request.setAttribute( ATT_CLIENT, client );
        request.setAttribute( ATT_ERREURS, clientBuilder );

        if ( clientBuilder.getErreurs().isEmpty() ) {
            clientManagerRemote.create( client );
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );

        } else {
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }

    }

    @Override
    public String getServletInfo() {

        return "Servlet de Creation d'un Client";

    }

}
