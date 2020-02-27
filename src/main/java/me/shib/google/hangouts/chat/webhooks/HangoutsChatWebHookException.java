package me.shib.google.hangouts.chat.webhooks;

public final class HangoutsChatWebHookException extends Exception {
    HangoutsChatWebHookException(String message) {
        super(message);
    }

    HangoutsChatWebHookException(Exception e) {
        super(e.getMessage(), e.getCause());
    }
}
