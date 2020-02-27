package me.shib.google.hangouts.chat.webhooks;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

final class WebhookUrlBuilder {

    private URL url;
    private String webhookURL;
    private String spaceKey;
    private String key;
    private String token;

    WebhookUrlBuilder(String webhookURL) throws MalformedURLException, HangoutsChatWebHookException, UnsupportedEncodingException {
        this.url = new URL(webhookURL);
        init();
    }

    private void init() throws HangoutsChatWebHookException, UnsupportedEncodingException {
        if (url.getHost().equalsIgnoreCase("chat.googleapis.com")) {
            String[] queries = url.getQuery().split("&");
            if (queries.length == 2) {
                if (queries[0].startsWith("key=") && queries[1].startsWith("token=")) {
                    this.webhookURL = "https://" + url.getHost() + "/";
                    String[] pathParams = url.getPath().split("/");
                    this.spaceKey = pathParams[3];
                    this.key = queries[0].replaceFirst("key=", "");
                    this.key = URLDecoder.decode(this.key, StandardCharsets.UTF_8.name());
                    this.token = queries[1].replaceFirst("token=", "");
                    this.token = URLDecoder.decode(this.token, StandardCharsets.UTF_8.name());
                    return;
                }
            }
        }
        throw new HangoutsChatWebHookException("Invalid Webhook URL");
    }

    String getWebhookURL() {
        return webhookURL;
    }

    String getSpaceKey() {
        return spaceKey;
    }

    String getKey() {
        return key;
    }

    String getToken() {
        return token;
    }
}
