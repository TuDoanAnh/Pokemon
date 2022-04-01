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
public class Category {
    private int CatID;
    private String CatName;

    public Category() {
    }

    public Category(int CatID, String CatName) {
        this.CatID = CatID;
        this.CatName = CatName;
    }

    public int getCatID() {
        return CatID;
    }

    public void setCatID(int CatID) {
        this.CatID = CatID;
    }

    public String getCatName() {
        return CatName;
    }

    public void setCatName(String CatName) {
        this.CatName = CatName;
    }

    @Override
    public String toString() {
        return "Category{" + "CatID=" + CatID + ", CatName=" + CatName + '}';
    }
    
    
}
