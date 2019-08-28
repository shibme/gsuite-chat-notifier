package me.shib.google.gsuite.chat.notifier.models.request;

import java.util.ArrayList;
import java.util.List;

public final class Section {

    private List<Widget> widgets;

    public Section(Widget widget) {
        this.widgets = new ArrayList<>();
        this.widgets.add(widget);
    }

    public void addWidget(Widget widget) {
        this.widgets.add(widget);
    }

}
