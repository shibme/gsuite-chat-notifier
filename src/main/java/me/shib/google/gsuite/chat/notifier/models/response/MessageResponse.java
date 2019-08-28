package me.shib.google.gsuite.chat.notifier.models.response;

import me.shib.google.gsuite.chat.notifier.models.request.Card;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public final class MessageResponse {

    private static transient final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX'Z'");
    private String name;
    private Sender sender;
    private String text;
    private List<Card> cards;
    private String previewText;
    private Space space;
    private String fallbackText;
    private String argumentText;
    private String createTime;

    public static SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public String getName() {
        return name;
    }

    public Sender getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getPreviewText() {
        return previewText;
    }

    public Space getSpace() {
        return space;
    }

    public String getFallbackText() {
        return fallbackText;
    }

    public String getArgumentText() {
        return argumentText;
    }

    public Date getCreateTime() throws ParseException {
        return dateFormat.parse(createTime);
    }
}
