package me.shib.google.gsuite.chat.notifier.models.request;

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
