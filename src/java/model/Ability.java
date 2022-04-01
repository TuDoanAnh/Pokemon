
package model;

public class Ability {
    private int AbiId;
    private String AbiName;
    private String Effect;

    public Ability() {
    }

    public Ability(String AbiName, String Effect, int AbiId) {
        this.AbiName = AbiName;
        this.Effect = Effect;
        this.AbiId = AbiId;
    }

    public String getAbiName() {
        return AbiName;
    }

    public void setAbiName(String AbiName) {
        this.AbiName = AbiName;
    }

    public String getEffect() {
        return Effect;
    }

    public void setEffect(String Effect) {
        this.Effect = Effect;
    }

    public int getAbiId() {
        return AbiId;
    }

    public void setAbiId(int AbiId) {
        this.AbiId = AbiId;
    }

    @Override
    public String toString() {
        return "Ability{" + "AbiId=" + AbiId + ", AbiName=" + AbiName + ", Effect=" + Effect + '}';
    }
    
    
    
    
}
