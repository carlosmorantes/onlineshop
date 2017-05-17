package de.java2enterprise.onlineshop;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class OnlineShopListener
 *
 */
@WebListener
public class OnlineShopListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public OnlineShopListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event)  { 
         HttpSession session = event.getSession();
         ServletContext servletContext = session.getServletContext();
         servletContext.log("SESSION CREATED: "+event.toString());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event)  { 
    	HttpSession session = event.getSession();
        ServletContext servletContext = session.getServletContext();
        servletContext.log("SESSION DESTROYED: "+event.toString());
    }
	
}
