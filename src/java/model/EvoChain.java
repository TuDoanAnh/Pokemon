/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Phong Vu
 */
public class EvoChain {
    private int EvoID;
    private String Stage1;
    private String Stage2;

    public EvoChain() {
    }

    public EvoChain(int EvoID, String Stage1, String Stage2) {
        this.EvoID = EvoID;
        this.Stage1 = Stage1;
        this.Stage2 = Stage2;
    }

    public int getEvoID() {
        return EvoID;
    }

    public void setEvoID(int EvoID) {
        this.EvoID = EvoID;
    }

    public String getStage1() {
        return Stage1;
    }

    public void setStage1(String Stage1) {
        this.Stage1 = Stage1;
    }

    public String getStage2() {
        return Stage2;
    }

    public void setStage2(String Stage2) {
        this.Stage2 = Stage2;
    }

    @Override
    public String toString() {
        return "EvoChain{" + "EvoID=" + EvoID + ", Stage1=" + Stage1 + ", Stage2=" + Stage2 + '}';
    }
    
    
}
