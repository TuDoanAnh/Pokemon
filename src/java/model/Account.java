
package model;

public class Account {
    private int AccID;
    private String Username;
    private String Password;
    private String Email;
    private String Poke1;
    private String Poke2;
    private String Poke3;
    private String Poke4;
    private String Poke5;
    private String Poke6;
    private String RoleID;
    public Account() {
    }

    public Account(int AccID, String Username, String Password, String Email, String Poke1, String Poke2, String Poke3, String Poke4, String Poke5, String Poke6, String RoleID) {
        this.AccID = AccID;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
        this.Poke1 = Poke1;
        this.Poke2 = Poke2;
        this.Poke3 = Poke3;
        this.Poke4 = Poke4;
        this.Poke5 = Poke5;
        this.Poke6 = Poke6;
        this.RoleID = RoleID;
    }

    public int getAccID() {
        return AccID;
    }

    public void setAccID(int AccID) {
        this.AccID = AccID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPoke1() {
        return Poke1;
    }

    public void setPoke1(String Poke1) {
        this.Poke1 = Poke1;
    }

    public String getPoke2() {
        return Poke2;
    }

    public void setPoke2(String Poke2) {
        this.Poke2 = Poke2;
    }

    public String getPoke3() {
        return Poke3;
    }

    public void setPoke3(String Poke3) {
        this.Poke3 = Poke3;
    }

    public String getPoke4() {
        return Poke4;
    }

    public void setPoke4(String Poke4) {
        this.Poke4 = Poke4;
    }

    public String getPoke5() {
        return Poke5;
    }

    public void setPoke5(String Poke5) {
        this.Poke5 = Poke5;
    }

    public String getPoke6() {
        return Poke6;
    }

    public void setPoke6(String Poke6) {
        this.Poke6 = Poke6;
    }

    public String getRoleID() {
        return RoleID;
    }

    public void setRoleID(String RoleID) {
        this.RoleID = RoleID;
    }

    @Override
    public String toString() {
        return "Account{" + "AccID=" + AccID + ", Username=" + Username + ", Password=" + Password + ", Email=" + Email + ", Poke1=" + Poke1 + ", Poke2=" + Poke2 + ", Poke3=" + Poke3 + ", Poke4=" + Poke4 + ", Poke5=" + Poke5 + ", Poke6=" + Poke6 + ", RoleID=" + RoleID + '}';
    }
    
    
    
    

    
    
    
}
