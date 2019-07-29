package Deck;

import java.util.ArrayList;

public class Card {
    private int number;
    private int color;

    /**
     * Initialize a card object.
     *
     * @param number The number of this card.
     * @param color The index of the color of this card
     */
    public Card(int number, int color) {
        this.number = number;
        this.color = color;
    }

    /**
     * Return the number of this card.
     *
     * @return The number of this card.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Return the index of the color of this card.
     *
     * @return The index of the color of this card.
     */
    public int getColor() {
        return color;
    }

    /**
     * Return the specific color for each index.
     *
     * '0' for Spades, '1' for Hearts, '2' for Clubs, '3' for Diamonds and '4' for Jokers.
     *
     * @return The specific color for each index.
     */
    private String getColorName() {
        switch (color) {
            case 0:
                return "♠";
            case 1:
                return "♡";
            case 2:
                return "♣";
            case 3:
                return "♢";
            case 4:
                return "Joker";
            default:
                return "";
        }
    }

    /**
     * Return the specific card name according to the card number.
     *
     * Return 'A' for '1' and '14' ('A' is '14' when in this deck 'A' is larger than 'K').
     * Return '2' for '2' and '15' ('2' is '15' when in this deck '2' is larger than 'A' where 'A' is '14').
     * Return 'J', 'Q', 'K' for '11', '12', '13' correspondingly.
     * Return '●' for '16' which is black joker and '○' for '17' which is red joker.
     *
     * @return The specific card name according to the card number.
     */
    private String getNumberName() {
        if (number == 1 || number == 14) {
            return "A";
        } else if (number == 2 || number == 15) {
            return "2";
        } else if (number == 11) {
            return "J";
        } else if (number == 12) {
            return "Q";
        } else if (number == 13) {
            return "K";
        } else if (number == 16) {
            return "●";
        } else if (number == 17) {
            return "○";
        } else {
            return String.valueOf(number);
        }
    }

    /**
     * Set the number of this card to the given <number>.
     *
     * @param number The new card number which is going to set to this card.
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Return the visible information of this card.
     *
     * @return The visible information of this card.
     */
    @Override
    public String toString() {
        return "{" + getColorName() + getNumberName() + "}";
    }

    /**
     * Check whether the cards from index <start> to <end> of the given <suit> all have the same number.
     *
     * @param suit An ArrayList of cards.
     * @param start The start index for checking.
     * @param end The end index for checking.
     * @return Return true if the cards in the given interval have the same number, false if not.
     */
    public static boolean equalCards(ArrayList<Card> suit, int start, int end) {
        for (int i = start; i < end; i ++) {
            if (suit.get(i).getNumber() != suit.get(i + 1).getNumber()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check whether all the cards in the given <suit> have the same number.
     *
     * @param suit An ArrayList of cards.
     * @return Return true if all the cards in the given <suit> have the same number, false if not.
     */
    public static boolean equalCards(ArrayList<Card> suit) {
        return equalCards(suit, 0, suit.size() - 1);
    }
}
