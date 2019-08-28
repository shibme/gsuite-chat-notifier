package me.shib.google.gsuite.chat.notifier.models.request;

import java.util.ArrayList;
import java.util.List;

public final class Card {

    private Header header;
    private List<Section> sections;

    public Card(Header header) {
        this.sections = new ArrayList<>();
        this.header = header;
    }

    public Card(Section section) {
        this.sections = new ArrayList<>();
        this.sections.add(section);
    }

    public void addSection(Section section) {
        this.sections.add(section);
    }
}
