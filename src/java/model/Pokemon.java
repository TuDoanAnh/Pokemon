
package model;

public class Pokemon {
    private int Id;
    private String Name;
    private double height;
    private double weight;
    private String Image;
    private double femaleRate;
    private double maleRate;
    private int HP;
    private int Attack;
    private int Defense;
    private int SpAttack;
    private int SpDefense;
    private int Speed;
    private String Type;
    private String Category;
    private int EvoID;
    private String Type2;
    private int Gen;
    private String describe;

    public Pokemon() {
    }

    public Pokemon(int Id, String Name, double height, double weight, String Image, double femaleRate, double maleRate, int HP, int Attack, int Defense, int SpAttack, int SpDefense, int Speed, String Type, String Category, int EvoID, String Type2, int Gen, String describe) {
        this.Id = Id;
        this.Name = Name;
        this.height = height;
        this.weight = weight;
        this.Image = Image;
        this.femaleRate = femaleRate;
        this.maleRate = maleRate;
        this.HP = HP;
        this.Attack = Attack;
        this.Defense = Defense;
        this.SpAttack = SpAttack;
        this.SpDefense = SpDefense;
        this.Speed = Speed;
        this.Type = Type;
        this.Category = Category;
        this.EvoID = EvoID;
        this.Type2 = Type2;
        this.Gen = Gen;
        this.describe = describe;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public double getFemaleRate() {
        return femaleRate;
    }

    public void setFemaleRate(double femaleRate) {
        this.femaleRate = femaleRate;
    }

    public double getMaleRate() {
        return maleRate;
    }

    public void setMaleRate(double maleRate) {
        this.maleRate = maleRate;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int Attack) {
        this.Attack = Attack;
    }

    public int getDefense() {
        return Defense;
    }

    public void setDefense(int Defense) {
        this.Defense = Defense;
    }

    public int getSpAttack() {
        return SpAttack;
    }

    public void setSpAttack(int SpAttack) {
        this.SpAttack = SpAttack;
    }

    public int getSpDefense() {
        return SpDefense;
    }

    public void setSpDefense(int SpDefense) {
        this.SpDefense = SpDefense;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int Speed) {
        this.Speed = Speed;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public int getEvoID() {
        return EvoID;
    }

    public void setEvoID(int EvoID) {
        this.EvoID = EvoID;
    }

    public String getType2() {
        return Type2;
    }

    public void setType2(String Type2) {
        this.Type2 = Type2;
    }

    public int getGen() {
        return Gen;
    }

    public void setGen(int Gen) {
        this.Gen = Gen;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "Id=" + Id + ", Name=" + Name + ", height=" + height + ", weight=" + weight + ", Image=" + Image + ", femaleRate=" + femaleRate + ", maleRate=" + maleRate + ", HP=" + HP + ", Attack=" + Attack + ", Defense=" + Defense + ", SpAttack=" + SpAttack + ", SpDefense=" + SpDefense + ", Speed=" + Speed + ", Type=" + Type + ", Category=" + Category + ", EvoID=" + EvoID + ", Type2=" + Type2 + ", Gen=" + Gen + ", describe=" + describe + '}';
    }
    
    
    
}
