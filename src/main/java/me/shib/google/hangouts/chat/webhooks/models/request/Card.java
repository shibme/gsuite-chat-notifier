package me.shib.google.hangouts.chat.webhooks.models.request;

import java.util.ArrayList;
import java.util.List;

public final class Card {

    private Header header;
    private List<Section> sections;

    public Card() {
        this.sections = new ArrayList<>();
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public void addSection(Section section) {
        this.sections.add(section);
    }
}
