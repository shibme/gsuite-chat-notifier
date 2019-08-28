package me.shib.google.gsuite.chat.notifier.models.request;

import java.util.ArrayList;
import java.util.List;

public final class Message {

    private List<Card> cards;

    public Message(Card card) {
        this.cards = new ArrayList<>();
        addCard(card);
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

}
