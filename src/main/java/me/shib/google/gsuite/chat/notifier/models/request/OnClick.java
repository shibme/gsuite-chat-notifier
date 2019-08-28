package me.shib.google.gsuite.chat.notifier.models.request;

public final class OnClick {

    private OpenLink openLink;

    public OnClick(String url) {
        this.openLink = new OpenLink(url);
    }

    private class OpenLink {
        private String url;

        private OpenLink(String url) {
            this.url = url;
        }
    }
}
