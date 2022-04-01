
package model;

public class Nature {
    private int NatureID;
    private String NatureName;
    private String Increase;
    private String Decrease;

    public Nature() {
    }

    public Nature(int NatureID, String NatureName, String Increase, String Decrease) {
        this.NatureID = NatureID;
        this.NatureName = NatureName;
        this.Increase = Increase;
        this.Decrease = Decrease;
    }

    public int getNatureID() {
        return NatureID;
    }

    public void setNatureID(int NatureID) {
        this.NatureID = NatureID;
    }

    public String getNatureName() {
        return NatureName;
    }

    public void setNatureName(String NatureName) {
        this.NatureName = NatureName;
    }

    public String getIncrease() {
        return Increase;
    }

    public void setIncrease(String Increase) {
        this.Increase = Increase;
    }

    public String getDecrease() {
        return Decrease;
    }

    public void setDecrease(String Decrease) {
        this.Decrease = Decrease;
    }

    @Override
    public String toString() {
        return "Nature{" + "NatureID=" + NatureID + ", NatureName=" + NatureName + ", Increase=" + Increase + ", Decrease=" + Decrease + '}';
    }
    
    
}
