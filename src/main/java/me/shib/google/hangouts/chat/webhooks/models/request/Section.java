package me.shib.google.hangouts.chat.webhooks.models.request;

import java.util.ArrayList;
import java.util.List;

public final class Section {

    private List<Widget> widgets;

    public Section() {
        this.widgets = new ArrayList<>();
    }

    public void addWidget(Widget widget) {
        this.widgets.add(widget);
    }

}
