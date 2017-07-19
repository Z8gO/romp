package zh.romp.test;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        HttpSession session = arg0.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
       while(attributeNames.hasMoreElements()){
           attributeNames.nextElement();
       }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        
        
        
    }

}
