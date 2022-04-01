
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
public class AccountDAO extends BaseDAO{
    public ArrayList<Account> getAll(){
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            String sql = "select * from Account where RoleId=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "Not");
            ResultSet rs = statement.executeQuery();
 
            while(rs.next()){
                Account acc = new Account();
                acc.setAccID(rs.getInt("AccId"));
                acc.setUsername(rs.getString("Username"));
                acc.setPassword(rs.getString("Password"));
                acc.setEmail(rs.getString("Email"));
                acc.setPoke1(rs.getString("Poke1"));
                acc.setPoke2(rs.getString("Poke2"));
                acc.setPoke3(rs.getString("Poke3"));
                acc.setPoke4(rs.getString("Poke4"));
                acc.setPoke5(rs.getString("Poke5"));
                acc.setPoke6(rs.getString("Poke6"));
                acc.setRoleID(rs.getString("RoleId"));
                accounts.add(acc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accounts;
    }
    public Account Checkexist(String user, String password){
        try {
            String sql = "select * from Account where Username= ? and Password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            Account acc = new Account();
            while(rs.next()){
                acc.setAccID(rs.getInt("AccId"));
                acc.setUsername(rs.getString("Username"));
                acc.setPassword(rs.getString("Password"));
                acc.setEmail(rs.getString("Email"));
                acc.setPoke1(rs.getString("Poke1"));
                acc.setPoke2(rs.getString("Poke2"));
                acc.setPoke3(rs.getString("Poke3"));
                acc.setPoke4(rs.getString("Poke4"));
                acc.setPoke5(rs.getString("Poke5"));
                acc.setPoke6(rs.getString("Poke6"));
                acc.setRoleID(rs.getString("RoleId"));
            }
            if(acc.getUsername()==null) acc=null;
            return acc;
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Account Checkuser(String user){
        try {
            String sql = "select * from Account where Username= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user);
            ResultSet rs = statement.executeQuery();
            Account acc = new Account();
            while(rs.next()){
                acc.setAccID(rs.getInt("AccId"));
                acc.setUsername(rs.getString("Username"));
                acc.setPassword(rs.getString("Password"));
                acc.setEmail(rs.getString("Email"));
                acc.setPoke1(rs.getString("Poke1"));
                acc.setPoke2(rs.getString("Poke2"));
                acc.setPoke3(rs.getString("Poke3"));
                acc.setPoke4(rs.getString("Poke4"));
                acc.setPoke5(rs.getString("Poke5"));
                acc.setPoke6(rs.getString("Poke6"));
                acc.setRoleID(rs.getString("RoleId"));
            }
            if(acc.getUsername()==null) acc=null;
            return acc;
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void updateAccountPoke(String idPoke, String positionId, String user) {
        try {
            String sql = "UPDATE [Account]\n"
                    + "   SET [Poke"+positionId+"] = "+idPoke+"\n"
                    + " WHERE [Username] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertAccount(String username, String password, String email) {
        try {
            String sql = "insert into Account(Username, Password, Email)\n" +
                         "values(? ,? ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateAccount(Account a) {
        try {
            String sql = "UPDATE [Account]\n"
                    + "Set Username=?, Password=?, Email=?, Poke1=?, Poke2=?,"
                    + "Poke3=?, Poke4=?, Poke5=?, Poke6=?"
                    + " WHERE Username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, a.getUsername());
            statement.setString(2, a.getPassword());
            statement.setString(3, a.getEmail());
            statement.setString(4, a.getPoke1());
            statement.setString(5, a.getPoke2());
            statement.setString(6, a.getPoke3());
            statement.setString(7, a.getPoke4());
            statement.setString(8, a.getPoke5());
            statement.setString(9, a.getPoke6());
            statement.setString(10, a.getUsername());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteAccount(String Username){
        try {
            String sql = "DELETE from Account WHERE Username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Username);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        
        dao.updateAccount(new Account(2, "tu123", "123456", "doananhtu2507@gmail.com", "1", "2", null, null, null, null, "Not"));
    }
}
