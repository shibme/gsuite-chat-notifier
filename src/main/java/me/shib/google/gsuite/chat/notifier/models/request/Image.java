package me.shib.google.gsuite.chat.notifier.models.request;

public final class Image {

    private String imageUrl;
    private OnClick onClick;

    public Image(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }
}
