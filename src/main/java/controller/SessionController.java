package controller;

import data.Opponents;
import data.Session;
import repo.SessionRepository;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author nilstes
 */
public class SessionController {

    private SessionRepository repo;
    private Opponents o = new Opponents();

    public SessionController(SessionRepository repo) {
        this.repo = repo;
    }
    
    public Session createSession(String userName) {
        Session s = null;
        if(!repo.existsSession(userName)) {
            s = new Session();
            s.setUserName(userName);
            s.setLoggedOn(new Date());
            repo.addSession(s);
            o.addUserName(userName);
        }
        return s;
    }

    public void removeSession(String userName) {
        if(repo.existsSession(userName)) {
            repo.removeSession(userName);
        }

    }
    
    public Opponents getPossibleOpponents(String myUserName) {
        createSession("test1");
        createSession("test2");

        return o;
    }
}