package me.shib.google.gsuite.chat.notifier.models.request;

public final class ImageButton extends Button {

    private Icon icon;
    private String iconUrl;

    public ImageButton(Icon icon, OnClick onClick) {
        super(onClick);
        this.icon = icon;
    }

    public ImageButton(String iconUrl, OnClick onClick) {
        super(onClick);
        this.iconUrl = iconUrl;
    }
}
