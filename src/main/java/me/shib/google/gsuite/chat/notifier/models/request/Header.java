package me.shib.google.gsuite.chat.notifier.models.request;

public final class Header {

    private String title;
    private String subtitle;
    private String imageUrl;
    private ImageStyle imageStyle;

    public Header(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setImage(String imageUrl, ImageStyle imageStyle) {
        this.imageUrl = imageUrl;
        this.imageStyle = imageStyle;
    }

    public enum ImageStyle {
        IMAGE, AVATAR
    }
}
