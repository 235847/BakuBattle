package com.example.bakubattle;

public class Domain extends Strategy{

    private String name;
    public static final String[] NAMES = {"Pyrus", "Ventus", "Aquos", "Darkus", "Haos", "Subterra"};

    public Domain(String text){
        try{
            validate(text);
            name = text;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error: wrong name for domain");
        }
    }

    private void validate(String text) throws Exception{
        for (String s : NAMES) {
            if (text.equals(s)) {
                return;
            }
        }
        throw new Exception();
    }

    public String getName() {
        return name;
    }
}
