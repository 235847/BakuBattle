package com.example.bakubattle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Deck {

    private ArrayList<Card> deck;

    public Deck(Player player, boolean domain_activation, boolean forbidden_card_activation, boolean open_card_activation) {
        deck = new ArrayList<>();

        /* Checking if the domain ability has been activated. */
        if(domain_activation){
            if(player.getDomain().getName().equals(Domain.NAMES[0])){
                pyrusBuff(player.getBakugan());
//                System.out.println("Player received pyrus boost");
            }
            else if(player.getDomain().getName().equals(Domain.NAMES[1])){
                ventusBuff(player.getBakugan());
//                System.out.println("Player received ventus boost");
            }
            else if(player.getDomain().getName().equals(Domain.NAMES[2])){
                aquosBuff(player.getBakugan());
//                System.out.println("Player received aquos boost");
            }
            else if(player.getDomain().getName().equals(Domain.NAMES[3])){
                darkusBuff(player.getBakugan());
//                System.out.println("Player received darkus boost");
            }
            else if(player.getDomain().getName().equals(Domain.NAMES[4])){
                haosBuff(player.getBakugan());
//                System.out.println("Player received haos boost");
            }
            else if(player.getDomain().getName().equals(Domain.NAMES[5])){
                subterraBuff(player.getBakugan());
//                System.out.println("Player received subterra boost");
            }
        }

        /* Checking if the open card ability has been activated. */
        if(open_card_activation){
            if(PassingClass.getInstance().getTeamA().getPlayer1().getDomain().getName().equals(player.getDomain().getName())){
                PassingClass.getInstance().getTeamA().getPlayer1().getBakugan().addHp(OpenCard.HP_BOOST);
//                System.out.println("Player 1A received boost");
            }
            else{
                PassingClass.getInstance().getTeamA().getPlayer1().getBakugan().subtractHp(OpenCard.DMG_DEALT);
//                System.out.println("Player 1A did not receive boost");
            }

            if(PassingClass.getInstance().getTeamA().getPlayer2().getDomain().getName().equals(player.getDomain().getName())){
                PassingClass.getInstance().getTeamA().getPlayer2().getBakugan().addHp(OpenCard.HP_BOOST);
//                System.out.println("Player 2A received boost");
            }
            else{
                PassingClass.getInstance().getTeamA().getPlayer2().getBakugan().subtractHp(OpenCard.DMG_DEALT);
//                System.out.println("Player 2A did not receive boost");
            }

            if(PassingClass.getInstance().getTeamB().getPlayer1().getDomain().getName().equals(player.getDomain().getName())){
                PassingClass.getInstance().getTeamB().getPlayer1().getBakugan().addHp(OpenCard.HP_BOOST);
//                System.out.println("Player 1B received boost");
            }
            else{
                PassingClass.getInstance().getTeamB().getPlayer1().getBakugan().subtractHp(OpenCard.DMG_DEALT);
//                System.out.println("Player 1B did not receive boost");
            }

            if(PassingClass.getInstance().getTeamB().getPlayer2().getDomain().getName().equals(player.getDomain().getName())){
                PassingClass.getInstance().getTeamB().getPlayer2().getBakugan().addHp(OpenCard.HP_BOOST);
//                System.out.println("Player 2B received boost");
            }
            else{
                PassingClass.getInstance().getTeamB().getPlayer2().getBakugan().subtractHp(OpenCard.DMG_DEALT);
//                System.out.println("Player 2B did not receive boost");
            }
        }

        /* Forbidden_card_activation */
        if(forbidden_card_activation){
            deck.add(ForbiddenCard.forgeForbiddenAsset(player));
        }

        /* Creating deck of cards. */
        int i = 0;
        for(Map.Entry<String, Integer> entry: player.getBakugan().getSkill_values().entrySet()){
            if(i >= 6){
                deck.add(new Card(player.getBakugan().getSkill_names().get(i),entry.getKey(), entry.getValue(),true));
            }
            else {
                deck.add(new Card(player.getBakugan().getSkill_names().get(i),entry.getKey(), entry.getValue(),false));
            }
            i++;
        }
    };

    public int size(){
        return deck.size();
    }

    public Card drawCard(int i){
        return deck.get(i);
    }

    public void clearCard(Card card){
        for(int i = 0; i < deck.size();i++){
            if(deck.get(i).getType().equals(card.getType())){
                deck.remove(deck.get(i));
                return;
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    private void aquosBuff(Bakugan bakugan){
        bakugan.addHp(300);
        bakugan.setXP_MULTIPLIER(0.35);
    }

    private void pyrusBuff(Bakugan bakugan){
        bakugan.addHp(300);
        for(Map.Entry<String, Integer> entry: bakugan.getSkill_values().entrySet()){
            entry.setValue(entry.getValue()+100);
        }
    }

    private void subterraBuff(Bakugan bakugan){
        bakugan.setXP_MULTIPLIER(0.35);
        bakugan.setBlock(true);
    }

    private void darkusBuff(Bakugan bakugan){
        bakugan.setXp(1);
        for(Map.Entry<String, Integer> entry: bakugan.getSkill_values().entrySet()){
            entry.setValue(entry.getValue()+100);
        }
    }

    private void haosBuff(Bakugan bakugan){
        bakugan.setXp(1);
        bakugan.setXP_MULTIPLIER(0.35);
    }

    private void ventusBuff(Bakugan bakugan){
        bakugan.addHp(300);
        bakugan.setBlock(true);
    }
}
