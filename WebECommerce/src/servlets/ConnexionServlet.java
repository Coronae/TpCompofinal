package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanSession.User;
import builders.UserBuilder;
import remote.ClientManagerRemote;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet( "/Connexion" )
public class ConnexionServlet extends HttpServlet {

    /**
     * 
     */

    private User              user;
    private UserBuilder       userBuilder;

    @EJB
    ClientManagerRemote       clientManagerRemote;

    private static final long serialVersionUID = -3976021118683231696L;

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

    }

}
