
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ability;
import model.Category;
import model.EvoChain;
import model.GamePatch;
import model.Nature;
import model.Pokemon;

public class PokemonDAO extends BaseDAO {

    public ArrayList getAll() {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        try {
            String sql = "with R as (Select P.[Pokemon Name], T.[Type Name] ,p.TypeID2 from Pokemon P join Type T on T.TypeID = P.TypeID), \n" +
                        "K as (select PokeID, [Pokemon Name], Img , Height, Weight, [Female Rate], [Male Rate], HP, Attack,Defense, [Sp.Attack], [Sp.Defense], Speed, CatID, EvoID, Gen, describe from Pokemon) \n" +
                        "select K.PokeID, K.[Pokemon Name], K.Img, K.Height, K.Weight, K.[Female Rate], K.[Male Rate],K.HP, K.Attack, K.Defense, K.[Sp.Attack],\n" +
                        "K.[Sp.Defense], K.Speed, K.EvoID, K.Gen, K.describe, C.[Cat Name], R.[Type Name], Type.[Type Name] as [Type Name 2] from R left join Type  on R.TypeID2 = Type.[TypeID] join K on K.[Pokemon Name] =R.[Pokemon Name]\n" +
                        "join Category C on C.CatID = K.CatID";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Pokemon p = new Pokemon();
                p.setId(rs.getInt("PokeID"));
                p.setName(rs.getString("Pokemon Name"));
                p.setImage(rs.getString("Img"));
                p.setHeight(rs.getDouble("Height"));
                p.setWeight(rs.getDouble("Weight"));
                p.setFemaleRate(rs.getDouble("Female Rate"));
                p.setMaleRate(rs.getDouble("Male Rate"));
                p.setHP(rs.getInt("HP"));
                p.setAttack(rs.getInt("Attack"));
                p.setDefense(rs.getInt("Defense"));
                p.setSpAttack(rs.getInt("Sp.Attack"));
                p.setSpDefense(rs.getInt("Sp.Defense"));
                p.setSpeed(rs.getInt("Speed"));
                p.setEvoID(rs.getInt("EvoID"));
                p.setCategory(rs.getString("Cat Name"));
                p.setType(rs.getString("Type Name"));
                p.setType2(rs.getString("Type Name 2"));
                p.setGen(rs.getInt("Gen"));
                p.setDescribe(rs.getString("describe"));
                pokemons.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pokemons;
    }
    public Pokemon getById(int Id){
        
        try {
            String sql = "with R as (Select P.[Pokemon Name], T.[Type Name] ,p.TypeID2 from Pokemon P join Type T on T.TypeID = P.TypeID), \n" +
"K as (select PokeID, [Pokemon Name], Img , Height, Weight, [Female Rate], [Male Rate], HP, Attack,Defense, [Sp.Attack], [Sp.Defense], Speed, CatID, EvoID, Gen, describe from Pokemon) \n" +
"select K.PokeID, K.[Pokemon Name], K.Img, K.Height, K.Weight, K.[Female Rate], K.[Male Rate],K.HP, K.Attack, K.Defense, K.[Sp.Attack],\n" +
"                         K.[Sp.Defense], K.Speed, K.EvoID, K.Gen, K.describe, C.[Cat Name], R.[Type Name], Type.[Type Name] as [Type Name 2] from R left join Type  on R.TypeID2 = Type.[TypeID] join K on K.[Pokemon Name] =R.[Pokemon Name]\n" +
"                         join Category C on C.CatID = K.CatID where PokeID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(Id));
            ResultSet rs = statement.executeQuery();
            Pokemon p = new Pokemon();
            while(rs.next()){              
                p.setId(rs.getInt("PokeID"));
                p.setName(rs.getString("Pokemon Name"));
                p.setImage(rs.getString("Img"));
                p.setHeight(rs.getDouble("Height"));
                p.setWeight(rs.getDouble("Weight"));
                p.setFemaleRate(rs.getDouble("Female Rate"));
                p.setMaleRate(rs.getDouble("Male Rate"));
                p.setHP(rs.getInt("HP"));
                p.setAttack(rs.getInt("Attack"));
                p.setDefense(rs.getInt("Defense"));
                p.setSpAttack(rs.getInt("Sp.Attack"));
                p.setSpDefense(rs.getInt("Sp.Defense"));
                p.setSpeed(rs.getInt("Speed"));
                p.setEvoID(rs.getInt("EvoID"));
                p.setCategory(rs.getString("Cat Name"));
                p.setType(rs.getString("Type Name"));
                p.setType2(rs.getString("Type Name 2"));
                p.setGen(rs.getInt("Gen"));
                p.setDescribe(rs.getString("describe"));
            }
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public String getName(String id){
        String name="";
       try{
            String sql="Select [Pokemon Name] from Pokemon where PokeID=" + id;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                name= rs.getString("Pokemon Name");
            }
        }catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return name;
    }
    public float[] getFirstType(String Type){
        try{
            String sql="Select * from Type where [Type Name]= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Type);
            ResultSet rs = statement.executeQuery();
            float[] db = new float[18];
            while(rs.next()){
                db[0] = rs.getFloat("Normal Rate");
                db[1] = rs.getFloat("Fire Rate");
                db[2] = rs.getFloat("Water Rate");
                db[3] = rs.getFloat("Grass Rate");
                db[4] = rs.getFloat("Electric Rate");
                db[5] = rs.getFloat("Ice Rate");
                db[6] = rs.getFloat("Fighting Rate");
                db[7] = rs.getFloat("Poison Rate");
                db[8] = rs.getFloat("Ground Rate");
                db[9] = rs.getFloat("Flying Rate");
                db[10] = rs.getFloat("Psychic Rate");
                db[11] = rs.getFloat("Bug Rate");
                db[12] = rs.getFloat("Rock Rate");
                db[13] = rs.getFloat("Ghost Rate");
                db[14] = rs.getFloat("Dragon Rate");
                db[15] = rs.getFloat("Dark Rate");
                db[16] = rs.getFloat("Steel Rate");
                db[17] = rs.getFloat("Fairy Rate");
            }
            return db;
        }catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public float[] getWeakType(String Type){
        try{
            String sql="Select [" + Type + " Rate] as Rate from Type";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            float[] db = new float[18];
            int i=0;
            while(rs.next()){
                db[i] = rs.getFloat("Rate");
                i++;
            }
            return db;
        }catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Ability> getAbility(int Id){
        ArrayList<Ability> abilities = new ArrayList<>();
        try {
            String sql = "select Ability.[Ability Name], Ability.Effect from [Poke-Abi] join Ability on [Poke-Abi].AbiID = Ability.AbiID\n" +
                            "where [Poke-Abi].PokeID=" + Id;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
               Ability a =new Ability();
               a.setAbiName(rs.getString("Ability Name"));
               a.setEffect(rs.getString("Effect"));
               abilities.add(a);
            }
 
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return abilities;
    }
    public int[] getEvoChain(int ID){
        int[] e = new int[3];
        try {
            String sql = "select PokeID from Pokemon where EvoID=" + ID;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            int i=0;
            while(rs.next()){
               e[i]= rs.getInt("PokeID");
               i++;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
    public ArrayList getGen(int Gen) {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        try {
            String sql = "with R as (Select P.[Pokemon Name], T.[Type Name] ,p.TypeID2 from Pokemon P join Type T on T.TypeID = P.TypeID), \n" +
                         "K as (select PokeID, [Pokemon Name], Img , Height, Weight, [Female Rate], [Male Rate], HP, Attack,Defense, [Sp.Attack], [Sp.Defense], Speed, CatID, EvoID, Gen, describe from Pokemon) \n" +
                         "select K.PokeID, K.[Pokemon Name], K.Img, K.Height, K.Weight, K.[Female Rate], K.[Male Rate],K.HP, K.Attack, K.Defense, K.[Sp.Attack],\n" +
                         "K.[Sp.Defense], K.Speed, K.EvoID, K.Gen, K.describe, C.[Cat Name], R.[Type Name], Type.[Type Name] as [Type Name 2] from R left join Type  on R.TypeID2 = Type.[TypeID] join K on K.[Pokemon Name] =R.[Pokemon Name]\n" +
                         "join Category C on C.CatID = K.CatID where K.Gen=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(Gen));
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Pokemon p = new Pokemon();
                p.setId(rs.getInt("PokeID"));
                p.setName(rs.getString("Pokemon Name"));
                p.setImage(rs.getString("Img"));
                p.setHeight(rs.getDouble("Height"));
                p.setWeight(rs.getDouble("Weight"));
                p.setFemaleRate(rs.getDouble("Female Rate"));
                p.setMaleRate(rs.getDouble("Male Rate"));
                p.setHP(rs.getInt("HP"));
                p.setAttack(rs.getInt("Attack"));
                p.setDefense(rs.getInt("Defense"));
                p.setSpAttack(rs.getInt("Sp.Attack"));
                p.setSpDefense(rs.getInt("Sp.Defense"));
                p.setSpeed(rs.getInt("Speed"));
                p.setEvoID(rs.getInt("EvoID"));
                p.setCategory(rs.getString("Cat Name"));
                p.setType(rs.getString("Type Name"));
                p.setType2(rs.getString("Type Name 2"));
                p.setGen(rs.getInt("Gen"));
                p.setDescribe(rs.getString("describe"));
                pokemons.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pokemons;
    }
    public ArrayList getGenDesc(int Gen) {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        try {
            String sql = "with R as (Select P.[Pokemon Name], T.[Type Name] ,p.TypeID2 from Pokemon P join Type T on T.TypeID = P.TypeID), \n" +
                         "K as (select PokeID, [Pokemon Name], Img , Height, Weight, [Female Rate], [Male Rate], HP, Attack,Defense, [Sp.Attack], [Sp.Defense], Speed, CatID, EvoID, Gen, describe from Pokemon) \n" +
                         "select K.PokeID, K.[Pokemon Name], K.Img, K.Height, K.Weight, K.[Female Rate], K.[Male Rate],K.HP, K.Attack, K.Defense, K.[Sp.Attack],\n" +
                         "K.[Sp.Defense], K.Speed, K.EvoID, K.Gen, K.describe, C.[Cat Name], R.[Type Name], Type.[Type Name] as [Type Name 2] from R left join Type  on R.TypeID2 = Type.[TypeID] join K on K.[Pokemon Name] =R.[Pokemon Name]\n" +
                         "join Category C on C.CatID = K.CatID where K.Gen=? order by k.PokeID DESC";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(Gen));
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Pokemon p = new Pokemon();
                p.setId(rs.getInt("PokeID"));
                p.setName(rs.getString("Pokemon Name"));
                p.setImage(rs.getString("Img"));
                p.setHeight(rs.getDouble("Height"));
                p.setWeight(rs.getDouble("Weight"));
                p.setFemaleRate(rs.getDouble("Female Rate"));
                p.setMaleRate(rs.getDouble("Male Rate"));
                p.setHP(rs.getInt("HP"));
                p.setAttack(rs.getInt("Attack"));
                p.setDefense(rs.getInt("Defense"));
                p.setSpAttack(rs.getInt("Sp.Attack"));
                p.setSpDefense(rs.getInt("Sp.Defense"));
                p.setSpeed(rs.getInt("Speed"));
                p.setEvoID(rs.getInt("EvoID"));
                p.setCategory(rs.getString("Cat Name"));
                p.setType(rs.getString("Type Name"));
                p.setType2(rs.getString("Type Name 2"));
                p.setGen(rs.getInt("Gen"));
                p.setDescribe(rs.getString("describe"));
                pokemons.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pokemons;
    }
    public GamePatch getPatch(int Id) {
        
        try {
            String sql = "select * from GamePatch where GameID = " + Id;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            GamePatch gamepatch = new GamePatch();
            while(rs.next()){
                gamepatch.setGameID(rs.getInt("GameID"));
                gamepatch.setGameName(rs.getString("GameName"));
                gamepatch.setPlot(rs.getString("Plot"));
                gamepatch.setMain(rs.getString("Main"));
                gamepatch.setProfessor(rs.getString("Professor"));
                gamepatch.setGymleader2(rs.getString("GymLeader2"));
                gamepatch.setGymleader3(rs.getString("GymLeader3"));
                gamepatch.setGymleader4(rs.getString("GymLeader4"));
                gamepatch.setGymleader5(rs.getString("GymLeader5"));
                gamepatch.setGymleader6(rs.getString("GymLeader6"));
                gamepatch.setGymleader7(rs.getString("GymLeader7"));
                gamepatch.setGymleader8(rs.getString("GymLeader8"));
                gamepatch.setGymleader1(rs.getString("GymLeader1"));
                gamepatch.setElite4(rs.getString("Elite4"));
                gamepatch.setEnemies(rs.getString("Enimies"));
                gamepatch.setImage1(rs.getString("Image1"));
                gamepatch.setImage2(rs.getString("Image2"));
                gamepatch.setPlatform(rs.getString("Platform"));
                gamepatch.setPlayer(rs.getString("Players"));
                gamepatch.setConnectivity("Connectivity");
                gamepatch.setGen(rs.getInt("Gen"));
                gamepatch.setRelease(rs.getInt("Release"));
            }
            return gamepatch;
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Nature getNature(int Id) {
        
        try {
            String sql = "select * from Nature where NatureID = " + Id;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            Nature n = new Nature();
            while(rs.next()){
                n.setNatureID(rs.getInt("NatureID"));
                n.setNatureName(rs.getString("Nature Name"));
                n.setIncrease(rs.getString("Increase Stat"));
                n.setDecrease(rs.getString("Decrease Stat"));
            }
            return n;
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void UpdateByID(Pokemon p) {
        
        try {
            String sql = "Update Pokemon\n" +
                         "Set HP=?, Attack=?, Defense=?, [Sp.Attack]=?, [Sp.Defense]=?, Speed=?, \n" +
                         "TypeID=?, TypeID2=?, Height=?, [Weight]=?\n" +
                         "where PokeID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, p.getHP());
            statement.setInt(2, p.getAttack());
            statement.setInt(3, p.getDefense());
            statement.setInt(4, p.getSpAttack());
            statement.setInt(5, p.getSpDefense());
            statement.setInt(6, p.getSpeed());
            statement.setString(7, p.getType());
            if(p.getType2().equals("NULL")) statement.setString(8, null);
            else statement.setString(8, p.getType2());
            statement.setDouble(9, p.getHeight());
            statement.setDouble(10, p.getWeight());
            statement.setInt(11, p.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void InsertPoke(Pokemon p) {
        
        try {
            String sql = "Insert into Pokemon(PokeID, [Pokemon Name], "
                    + "Height, [Weight], [Male Rate], [Female Rate], CatID, "
                    + "Img, TypeID, TypeID2, describe, HP, Attack, Defense, "
                    + "[Sp.Attack], [Sp.Defense], Speed, EvoID)\n" +
                    "values(?, ?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?, ?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, p.getId());
            statement.setString(2, p.getName());
            statement.setDouble(3, p.getHeight());
            statement.setDouble(4, p.getWeight());
            statement.setDouble(5, p.getMaleRate());
            statement.setDouble(6, p.getFemaleRate());
            statement.setString(7, p.getCategory());
            statement.setString(8, p.getImage());
            statement.setString(9, p.getType());
            if(p.getType2().equals("NULL")) statement.setString(10, null);
            else statement.setString(10, p.getType2());
            statement.setString(11, p.getDescribe());
            statement.setInt(12, p.getHP());
            statement.setInt(13, p.getAttack());
            statement.setInt(14, p.getDefense());
            statement.setInt(15, p.getSpAttack());
            statement.setInt(16, p.getSpDefense());
            statement.setInt(17, p.getSpeed());
            statement.setInt(18, p.getEvoID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int getNumberPoke(){
        int num=0;
        try {
            String sql = "select COUNT(PokeID) as num from Pokemon";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
               num=rs.getInt("num");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }
    public int getNumberAbility(){
        int num=0;
        try {
            String sql = "select COUNT(AbiID) as num from Ability";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
               num=rs.getInt("num");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }
    
    public int getNumbernature(){
        int num=0;
        try {
            String sql = "select COUNT(NatureID) as num from Nature";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
               num=rs.getInt("num");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }
    public int getNumberCategory(){
        int num=0;
        try {
            String sql = "select COUNT(CatID) as num from Category";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
               num=rs.getInt("num");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }
    public void InserPokeAbi(int pokeId, int AbiID) {
        
        try {
            String sql = "Insert into [Poke-Abi](PokeID, AbiID)"
                            + "values(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pokeId);
            statement.setInt(2, AbiID);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void DeletePoke(String Id){
        try {
            String sql = "DELETE from Pokemon WHERE PokeID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(Id));
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void DeletePokeAbi(String Id){
        try {
            String sql = "Delete from [Poke-Abi] where PokeID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(Id));
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void DeletePokeAbibyAbi(String Id){
        try {
            String sql = "Delete from [Poke-Abi] where AbiID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(Id));
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Ability> getAllAbility(){
        ArrayList<Ability> a = new ArrayList<>();
        try {
            String sql = "select * from Ability";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Ability abi = new Ability();
                abi.setAbiId(rs.getInt("AbiID"));
                abi.setAbiName(rs.getString("Ability Name"));
                abi.setEffect(rs.getString("Effect"));
                a.add(abi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    public Ability getAbilitybyID(int ID){
        Ability abi = new Ability();
        try {
            String sql = "select * from Ability where AbiID = " + ID;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){        
                abi.setAbiId(rs.getInt("AbiID"));
                abi.setAbiName(rs.getString("Ability Name"));
                abi.setEffect(rs.getString("Effect"));
            }
            return abi;
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void UpdateAbility(Ability a){
        try {
            String sql = "Update Ability\n" +
                           "set [Ability Name] =?, Effect=?\n" +
                           "where AbiID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, a.getAbiName());
            statement.setString(2, a.getEffect());
            statement.setInt(3, a.getAbiId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void DeleteAbility(String Id){
        try {
            String sql = "Delete from Ability where AbiID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(Id));
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void InsertAbility(Ability a){
        try {
            String sql = "Insert into Ability(AbiID, [Ability Name], Effect)"
                    + "values(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, a.getAbiId());
            statement.setString(2, a.getAbiName());
            statement.setString(3, a.getEffect());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Nature> getAllNature(){
        ArrayList<Nature> a = new ArrayList<>();
        try {
            String sql = "select * from Nature";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Nature na = new Nature();
                na.setNatureID(rs.getInt("NatureID"));
                na.setNatureName(rs.getString("Nature Name"));
                na.setIncrease(rs.getString("Increase Stat"));
                na.setDecrease(rs.getString("Decrease Stat"));
                a.add(na);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    public void UpdateNature(Nature a){
        try {
            String sql = "Update Nature\n" +
                           "set [Nature Name] =?, [Increase Stat]=?, [Decrease Stat]=?\n" +
                           "where NatureID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, a.getNatureName());
            statement.setString(2, a.getIncrease());
            statement.setString(3, a.getDecrease());
            statement.setInt(4, a.getNatureID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void InsertNature(Nature n){
        try {
            String sql = "Insert into Nature(NatureID, [Nature Name], [Increase Stat], [Decrease Stat])"
                    + "values(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, n.getNatureID());
            statement.setString(2, n.getNatureName());
            statement.setString(3, n.getIncrease());
            statement.setString(4, n.getDecrease());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void DeleteNature(String Id){
        try {
            String sql = "Delete from Nature where NatureID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(Id));
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Category> getAllCategory(){
        ArrayList<Category> cat = new ArrayList<>();
        try {
            String sql = "select * from Category";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Category c  = new Category();
                c.setCatID(rs.getInt("CatID"));
                c.setCatName(rs.getString("Cat Name"));
                cat.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    public void InsertCategory(Category n){
        try {
            String sql = "Insert into Category(CatID, [Cat Name])"
                    + "values(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, n.getCatID());
            statement.setString(2, n.getCatName());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void UpdateCategory(Category c){
        try {
            String sql = "Update Category\n" +
                           "set [Cat Name]=?\n" +
                           "where CatID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(2, c.getCatID());
            statement.setString(1, c.getCatName());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void DeleteCategory(String Id){
        try {
            String sql = "Delete from Category where CatID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(Id));
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<EvoChain> getAllEvoChain(){
        ArrayList<EvoChain> Evo = new ArrayList<>();
        try {
            String sql = "select * from [Evo Chain]";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                EvoChain e  = new EvoChain();
                e.setEvoID(rs.getInt("EvoID"));
                e.setStage1(rs.getString("Stage1"));
                e.setStage2(rs.getString("Stage2"));
                Evo.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Evo;
    }
    public void InsertEvoChain(EvoChain e){
        try {
            String sql = "Insert into [Evo Chain](EvoID, Stage1, Stage2)"
                    + "values(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, e.getEvoID());
            statement.setString(2,e.getStage1());
            statement.setString(3, e.getStage2());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void UpdateEvoChain(EvoChain e){
        try {
            String sql = "Update [Evo Chain]\n" +
                           "set [Stage1]=?, [Stage2]=?\n" +
                           "where EvoID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2, e.getStage2());
            statement.setString(1, e.getStage1());
            statement.setInt(3, e.getEvoID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void DeleteEvoChain(String Id){
        try {
            String sql = "Delete from [Evo Chain] where EvoID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(Id));
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        PokemonDAO dao =new PokemonDAO();
        EvoChain e = new EvoChain(162, "20", "36");
        dao.UpdateEvoChain(e);
    }
  }

