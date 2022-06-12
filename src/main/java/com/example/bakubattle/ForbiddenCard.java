package com.example.bakubattle;

import java.util.Map;

public class ForbiddenCard extends Strategy{

    public static Card forgeForbiddenAsset(Player player){
        if(player.getDomain().getName().equals(Domain.NAMES[0])){
            return pyrusBuff();
        }
        else if(player.getDomain().getName().equals(Domain.NAMES[1])){
            return ventusBuff();
        }
        else if(player.getDomain().getName().equals(Domain.NAMES[2])){
            return aquosBuff();
        }
        else if(player.getDomain().getName().equals(Domain.NAMES[3])){
            return darkusBuff();
        }
        else if(player.getDomain().getName().equals(Domain.NAMES[4])){
            return haosBuff();
        }
        else if(player.getDomain().getName().equals(Domain.NAMES[5])){
            return subterraBuff();
        }
        else {
            return new Card("Error","error", 0, false);
        }
    }

    private static Card aquosBuff(){
        return new Card("Wezwanie Tonących", "forbiddenAquos", 500, false);
    }

    private static Card pyrusBuff(){
        return new Card("Erupcja Pyrusa", "forbiddenPyrus", -2, false);
    }

    private static Card subterraBuff(){
        return new Card("Skażona Ziemia", "forbiddenSubterra", -2, true);
    }

    private static Card darkusBuff(){
        return new Card("Zew Zniszczenia", "forbiddenDarkus", 1000, false);
    }

    private static Card haosBuff(){
        return new Card("Promienie Aurory", "forbiddenHaos", -2, false);
    }

    private static Card ventusBuff(){
        return new Card("Powiew Destrukcji", "forbiddenVentus", -2, true);
    }

}
