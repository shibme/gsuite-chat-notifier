package me.shib.google.hangouts.chat.webhooks.models.request;

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
