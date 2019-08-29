package me.shib.google.gsuite.chat.notifier.models.request;

public final class KeyValue {

    private String topLabel;
    private String content;
    private boolean contentMultiline;
    private String bottomLabel;
    private OnClick onClick;
    private Icon icon;
    private String iconUrl;
    private Button button;

    public KeyValue(String content) {
        this.content = content;
    }

    public void setTopLabel(String topLabel) {
        this.topLabel = topLabel;
    }

    public void setContentMultiline(boolean contentMultiline) {
        this.contentMultiline = contentMultiline;
    }

    public void setBottomLabel(String bottomLabel) {
        this.bottomLabel = bottomLabel;
    }

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
        this.iconUrl = null;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        this.icon = null;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
