package me.shib.google.hangouts.chat.webhooks.models.request;

import java.util.ArrayList;
import java.util.List;

public final class Message {

    private List<Card> cards;

    public Message() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

}
