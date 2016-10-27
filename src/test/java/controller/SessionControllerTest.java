package controller;

import data.Session;
import junit.framework.TestCase;
import org.junit.Test;
import repo.SessionRepository;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.NotAuthorizedException;

/**
 * @author nilstes
 */
public class SessionControllerTest extends TestCase {
    SessionRepository repo = new SessionRepository();
    SessionController sc = new SessionController(repo);
    String username = "testUser";
    String username1 = "testUser1";

    @Test
    public void testThatUserCanLogOnWithOnlyUsername() {
        Session s = sc.createSession(username);
        assertNotNull(s);
    }

    @Test
    public void testThatUsernameIsUnique() {
        Session s1 = sc.createSession(username1);
        Session s2 = sc.createSession(username1);
        assertNull(s2);
    }
}
