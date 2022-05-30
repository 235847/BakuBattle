package com.example.bakubattle;

public class Domain {

    enum activation{
        active,
        not_active
    };

    String name;
    final static private String[] NAMES = {"Aquos", "Pyrus", "Darkus", "Haos", "Ventus", "Subterra"};
    activation status = activation.not_active;

    public Domain(String text){
        try{
            validate(text);
            name = text;
        }catch(Exception e){
            System.out.println("Error: wrong name for domain");
        }
    }

    private void validate(String text) throws Exception{
        for(int i = 0; i< NAMES.length;i++){
            if(text.equals(NAMES[i])){
                return;
            }
        }
        throw new Exception();
    }
}
