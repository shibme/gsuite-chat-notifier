package me.shib.google.hangouts.chat.webhooks.models.request;

public final class ImageButton {

    private Icon icon;
    private String iconUrl;
    private OnClick onClick;

    public ImageButton(Icon icon, OnClick onClick) {
        this.icon = icon;
        this.onClick = onClick;
    }

    public ImageButton(String iconUrl, OnClick onClick) {
        this.iconUrl = iconUrl;
        this.onClick = onClick;
    }
}
