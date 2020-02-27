package me.shib.google.hangouts.chat.webhooks.test;

import me.shib.google.hangouts.chat.webhooks.HangoutsChatWebHookClient;
import me.shib.google.hangouts.chat.webhooks.HangoutsChatWebHookException;
import me.shib.google.hangouts.chat.webhooks.models.request.*;

public final class HangoutsChatWebHookSample {
    public static void main(String[] args) throws HangoutsChatWebHookException {
        HangoutsChatWebHookClient webHookClient = HangoutsChatWebHookClient.getClient();
        Message message = new Message();
        Card card = new Card();
        Section section = new Section();
        TextParagraph paragraph = new TextParagraph("Hello <b>World</b>");
        Widget widget = new Widget(paragraph);
        section.addWidget(widget);
        card.addSection(section);
        webHookClient.sendMessage(message);
    }
}
