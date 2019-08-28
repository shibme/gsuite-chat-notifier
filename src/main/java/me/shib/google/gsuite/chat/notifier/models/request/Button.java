package me.shib.google.gsuite.chat.notifier.models.request;

public abstract class Button {
    private OnClick onClick;

    public Button(OnClick onClick) {
        this.onClick = onClick;
    }
}
