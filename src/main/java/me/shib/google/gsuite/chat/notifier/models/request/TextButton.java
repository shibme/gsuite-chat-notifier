package me.shib.google.gsuite.chat.notifier.models.request;

public final class TextButton {

    private String text;
    private OnClick onClick;

    public TextButton(String text, OnClick onClick) {
        this.text = text;
        this.onClick = onClick;
    }
}
