## Hangouts Chat WebHook
[![Maven Central](https://img.shields.io/maven-central/v/me.shib.lib.google/hangouts-chat-webhook.svg?label=hangouts-chat-webhook)](https://maven-badges.herokuapp.com/maven-central/me.shib.lib.google/hangouts-chat-webhook)
[![Build Status](https://gitlab.com/shibme/hangouts-chat-webhook/badges/master/pipeline.svg)](https://gitlab.com/shibme/hangouts-chat-webhook/pipelines)

Google Hangouts Chat WebHooks based integration for Java

### Maven Dependency
Include this as a dependency in your project's `pom.xml`
```xml
<dependencies>
    <dependency>
        <groupId>me.shib.lib.google</groupId>
        <artifactId>hangouts-chat-webhook</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

### What Next?
Create a WebHook from your Hangouts Chat room and use the WebHook URL to create an instance of `HangoutsChatWebHookClient`
```java
public final class HangoutsChatWebHookSample {
    public static void main(String[] args) throws HangoutsChatWebHookException {
        HangoutsChatWebHookClient webHookClient = HangoutsChatWebHookClient.getClient("https://chat.googleapis.com/.....");
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
```
Alternatively, you can set the WebHook URL through the environment variable `HANGOUTS_CHAT_WEBHOOK_URL` and create an instance of `HangoutsChatWebHookClient`
```java
public final class HangoutsChatWebHookSample {
    public static void main(String[] args) throws HangoutsChatWebHookException {
        HangoutsChatWebHookClient webHookClient = HangoutsChatWebHookClient.getClient();
    }
}
```
