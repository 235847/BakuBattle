package com.example.bakubattle;

public class Domain {

    enum activation{
        active,
        not_active
    };

    String name;
    public static final String[] NAMES = {"Pyrus", "Ventus", "Aquos", "Darkus", "Haos", "Subterra"};
    activation status = activation.not_active;

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
}
