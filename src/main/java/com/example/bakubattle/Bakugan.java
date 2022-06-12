package com.example.bakubattle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bakugan {

    private String name;
    private int hp;
    public static final int HP_THRESHOLD = 5000;
    private double xp;
    private double XP_MULTIPLIER;
    private boolean xp_loaded = false;
    private static final double XP_THRESHOLD = 1;
    private HashMap<String,Integer> skill_values;
    private ArrayList<String> skill_names;
    private boolean is_block = false;

    public Bakugan(int record){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakugan","root","");        //connecting with local database
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM bakubattle WHERE bakubattle.bakuID = "+ record);     //passing our query through the statement
            while (rs.next()){
                name = rs.getString("name");
                hp = rs.getInt("hp");
                XP_MULTIPLIER = rs.getDouble("xp");
                loadSkillValue(rs);                                  //HashMap filling
                loadSkillName(rs);                                   //ArrayList filling
                xp = 0;
            }
            statement.close();                                  //closing the conversation with database.
            connection.close();
        }catch (Exception e){
            System.out.println("Error: loading from database\n");
            e.printStackTrace();
        }
    }

    private void loadSkillValue(ResultSet rs) throws Exception{
        skill_values = new HashMap<>();
        skill_values.put("transferSingle",rs.getInt("transferSingle"));
        skill_values.put("transferArea",rs.getInt("transferArea"));
        skill_values.put("attackSingle",rs.getInt("attackSingle"));
        skill_values.put("attackArea",rs.getInt("attackArea"));
        skill_values.put("hpBoostv1",rs.getInt("hpBoostv1"));
        skill_values.put("hpBoostv2",rs.getInt("hpBoostv2"));
        skill_values.put("blockHealFriend",rs.getInt("blockHealFriend"));
        skill_values.put("blockHealTeam",rs.getInt("blockHealTeam"));
    }

    private void loadSkillName(ResultSet rs) throws Exception{
        skill_names = new ArrayList<>();
        skill_names.add(rs.getString("transferSingleName"));
        skill_names.add(rs.getString("transferAreaName"));
        skill_names.add(rs.getString("attackSingleName"));
        skill_names.add(rs.getString("attackAreaName"));
        skill_names.add(rs.getString("hpBoostv1Name"));
        skill_names.add(rs.getString("hpBoostv2Name"));
        skill_names.add(rs.getString("blockHealFriendName"));
        skill_names.add(rs.getString("blockHealTeamName"));
    }

    public void display(){
        System.out.println("----------------Bakugan--------------");
        System.out.println("My name is: "+name);
        System.out.println("My hp: "+hp);
        System.out.println("My xp multiplier: "+XP_MULTIPLIER);
        int i = 0;
        for(Map.Entry<String,Integer> set: skill_values.entrySet()){
            System.out.println(skill_names.get(i)+" -> "+set.getValue()+" ( type: "+set.getKey()+" )");
            i++;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
        if(this.xp > XP_THRESHOLD){
            xp_loaded = true;
            this.xp -= XP_THRESHOLD;
        }
    }

    public double getXP_MULTIPLIER() {
        return XP_MULTIPLIER;
    }

    public void setXP_MULTIPLIER(double XP_MULTIPLIER) {
        this.XP_MULTIPLIER = XP_MULTIPLIER;
    }

    public HashMap<String, Integer> getSkill_values() {
        return skill_values;
    }

    public void setSkill_values(HashMap<String, Integer> skill_values) {
        this.skill_values = skill_values;
    }

    public ArrayList<String> getSkill_names() {
        return skill_names;
    }

    public void setSkill_names(ArrayList<String> skill_names) {
        this.skill_names = skill_names;
    }

    public boolean isBlock() {
        return is_block;
    }

    public void setBlock(boolean is_block) {
        this.is_block = is_block;
    }

    public void addHp(int x) {
        hp += x;
    }

    public void subtractHp(int x){
        hp -= x;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public void doubleHp_positive(){
        hp *= 2;
    }

    public void doubleHp_negative(){
        hp /= 2;
    }

    public boolean isXpLoaded() {
        return xp_loaded;
    }

    public void addXp(double v) {
        xp+=v;
        if(xp > XP_THRESHOLD){
            xp_loaded = true;
            xp -= XP_THRESHOLD;
        }
    }

    public void unloadXp() {
        xp_loaded = false;
    }


}
