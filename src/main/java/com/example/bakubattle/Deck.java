package com.example.bakubattle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Deck {

    private ArrayList<Card> deck;

    public Deck(Player player, boolean domain_activation, boolean forbidden_card_activation, boolean open_card_activation) {
        deck = new ArrayList<>();
        int i = 0;
        if(domain_activation){
            if(player.getDomain().getName().equals(Domain.NAMES[0])){
                pyrusBuff(player.getBakugan());
            }
            else if(player.getDomain().getName().equals(Domain.NAMES[1])){
                ventusBuff(player.getBakugan());
            }
            else if(player.getDomain().getName().equals(Domain.NAMES[2])){
                aquosBuff(player.getBakugan());
            }
            else if(player.getDomain().getName().equals(Domain.NAMES[3])){
                darkusBuff(player.getBakugan());
            }
            else if(player.getDomain().getName().equals(Domain.NAMES[4])){
                haosBuff(player.getBakugan());
            }
            else if(player.getDomain().getName().equals(Domain.NAMES[5])){
                subterraBuff(player.getBakugan());
            }
        }
        for(Map.Entry<String, Integer> entry: player.getBakugan().getSkill_values().entrySet()){
            deck.add(new Card(player.getBakugan().getSkill_names().get(i),entry.getKey(), entry.getValue()));
            i++;
        }
    };

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public Card drawCard() {
        return deck.remove(deck.size() - 1);
    }

    public Card drawCard(int id) {
        return deck.remove(id);
    }

    public void testDiplayDeck() {
    }

    private void aquosBuff(Bakugan bakugan){
        bakugan.setHp(bakugan.getHp()+300);
        bakugan.setXP_MULTIPLIER(0.35);
    }

    private void pyrusBuff(Bakugan bakugan){
        bakugan.setHp(bakugan.getHp()+300);
        for(Map.Entry<String, Integer> entry: bakugan.getSkill_values().entrySet()){
            entry.setValue(entry.getValue()+100);
        }
    }

    private void subterraBuff(Bakugan bakugan){
        bakugan.setHp(bakugan.getHp()+200);
        bakugan.setXP_MULTIPLIER(0.38);
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
        bakugan.setHp(bakugan.getHp()+300);
        bakugan.setBlock(true);
    }
}
