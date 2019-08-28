package me.shib.google.gsuite.chat.notifier.models.request;

public final class TextButton extends Button {

    private String text;

    public TextButton(String text, OnClick onClick) {
        super(onClick);
        this.text = text;
    }
}
