package me.shib.google.gsuite.chat.notifier.test;

import me.shib.google.gsuite.chat.notifier.GSuiteChatException;
import me.shib.google.gsuite.chat.notifier.GSuiteChatNotifier;
import me.shib.google.gsuite.chat.notifier.models.request.Card;
import me.shib.google.gsuite.chat.notifier.models.request.Header;
import me.shib.google.gsuite.chat.notifier.models.request.Message;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

public final class Test {

    public static void main(String[] args) throws GSuiteChatException, MalformedURLException, UnsupportedEncodingException {
        String webhookURL = System.getenv("CHAT_BOT_WEBHOOK_URL");
        GSuiteChatNotifier notifier = new GSuiteChatNotifier(webhookURL);
        notifier.sendMessage(new Message(new Card(new Header("Hello World!"))));
    }

}
