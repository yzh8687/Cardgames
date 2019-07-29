package FightingTheLandlord;

import Deck.Card;
import Interfaces.Player;

import java.util.ArrayList;
import java.util.Comparator;

public class FTLPlayer implements Player {
    private int playerId;
    private ArrayList<Card> hands = new ArrayList<>();

    FTLPlayer(int playerId) {
        this.playerId = playerId;
    }

    @Override
    public int getPlayerId() {
        return playerId;
    }

    @Override
    public ArrayList<Card> getHands() {
        return hands;
    }

    @Override
    public void sortHands() {
        hands.sort(new FTLCardsComparator());
    }
}

class FTLCardsComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        int numCompResult = Integer.compare(o1.getNumber(), o2.getNumber());
        if (numCompResult != 0) {
            return numCompResult;
        } else {
            return Integer.compare(o1.getColor(), o2.getColor());
        }
    }
}
