
package DAL;

import java.util.ArrayList;
import model.Account;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author Phong Vu
 */

public class AccountDAOTest {
    
    public AccountDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetAll() {
        System.out.println("getAll");
        AccountDAO instance = new AccountDAO();
        ArrayList<Account> expResult = null;
        ArrayList<Account> result = instance.getAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCheckexist() {
        System.out.println("Checkexist");
        String user = "";
        String password = "";
        AccountDAO instance = new AccountDAO();
        Account expResult = null;
        Account result = instance.Checkexist(user, password);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCheckuser() {
        System.out.println("Checkuser");
        String user = "";
        AccountDAO instance = new AccountDAO();
        Account expResult = null;
        Account result = instance.Checkuser(user);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateAccountPoke() {
        System.out.println("updateAccountPoke");
        String idPoke = "";
        String positionId = "";
        String user = "";
        AccountDAO instance = new AccountDAO();
        instance.updateAccountPoke(idPoke, positionId, user);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertAccount() {
        System.out.println("insertAccount");
        String username = "";
        String password = "";
        String email = "";
        AccountDAO instance = new AccountDAO();
        instance.insertAccount(username, password, email);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateAccount() {
        System.out.println("updateAccount");
        Account a = null;
        AccountDAO instance = new AccountDAO();
        instance.updateAccount(a);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteAccount() {
        System.out.println("deleteAccount");
        String Username = "";
        AccountDAO instance = new AccountDAO();
        instance.deleteAccount(Username);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        AccountDAO.main(args);
        fail("The test case is a prototype.");
    }
    
}
