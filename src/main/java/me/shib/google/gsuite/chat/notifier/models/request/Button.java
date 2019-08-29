package me.shib.google.gsuite.chat.notifier.models.request;

public final class Button {

    private TextButton textButton;
    private ImageButton imageButton;

    public Button(TextButton textButton) {
        this.textButton = textButton;
    }

    public Button(ImageButton imageButton) {
        this.imageButton = imageButton;
    }
}
