package me.shib.google.gsuite.chat.notifier.models.request;

public final class Widget {

    private TextParagraph textParagraph;
    private KeyValue keyValue;
    private Image image;

    public Widget(TextParagraph textParagraph) {
        this.textParagraph = textParagraph;
    }

    public Widget(KeyValue keyValue) {
        this.keyValue = keyValue;
    }

    public Widget(Image image) {
        this.image = image;
    }
}
