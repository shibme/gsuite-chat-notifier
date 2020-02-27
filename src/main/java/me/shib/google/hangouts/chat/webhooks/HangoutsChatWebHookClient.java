package me.shib.google.hangouts.chat.webhooks;

import com.google.gson.Gson;
import me.shib.google.hangouts.chat.webhooks.models.request.Message;
import me.shib.google.hangouts.chat.webhooks.models.response.MessageResponse;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class HangoutsChatWebHookClient {

    private static final transient Gson gson = new Gson();
    private static final transient Map<String, HangoutsChatWebHookClient> clientMap = new HashMap<>();

    private HangoutsChatWebHookAPI hangoutsChatWebHookApi;
    private String spaceKey;
    private String key;
    private String token;

    private HangoutsChatWebHookClient(String webHookURL) throws HangoutsChatWebHookException {
        try {
            WebhookUrlBuilder webhookUrlBuilder = new WebhookUrlBuilder(webHookURL);
            this.spaceKey = webhookUrlBuilder.getSpaceKey();
            this.key = webhookUrlBuilder.getKey();
            this.token = webhookUrlBuilder.getToken();
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new HeaderInterceptor())
                    .build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(webhookUrlBuilder.getWebhookURL())
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            this.hangoutsChatWebHookApi = retrofit.create(HangoutsChatWebHookAPI.class);
        } catch (Exception e) {
            throw new HangoutsChatWebHookException(e);
        }
    }

    public static synchronized HangoutsChatWebHookClient getClient(String webHookURL) throws HangoutsChatWebHookException {
        HangoutsChatWebHookClient client = clientMap.get(webHookURL);
        if (client == null) {
            client = new HangoutsChatWebHookClient(webHookURL);
            clientMap.put(webHookURL, client);
        }
        return client;
    }

    public static synchronized HangoutsChatWebHookClient getClient() throws HangoutsChatWebHookException {
        String webHookUrlVarName = "HANGOUTS_CHAT_WEBHOOK_URL";
        String webHookUrl = System.getenv(webHookUrlVarName);
        if (webHookUrl == null || webHookUrl.isEmpty()) {
            throw new HangoutsChatWebHookException("Please set the WebHook URL through" + webHookUrlVarName + " variable");
        }
        return getClient(webHookUrl);
    }

    public MessageResponse sendMessage(Message message) throws HangoutsChatWebHookException {
        try {
            Response<MessageResponse> response = hangoutsChatWebHookApi.sendMessage(spaceKey, key, token, message).execute();
            MessageResponse messageResponse = response.body();
            if (response.code() == 200 && messageResponse != null) {
                return messageResponse;
            }
            if (response.errorBody() != null) {
                Object error = gson.fromJson(response.errorBody().string(), Object.class);
                throw new HangoutsChatWebHookException(gson.toJson(error));
            }
            throw new HangoutsChatWebHookException("Unknown Error Occurred!");
        } catch (IOException e) {
            throw new HangoutsChatWebHookException(e.getMessage());
        }

    }

    private static final class HeaderInterceptor implements Interceptor {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request requestWithHeaders = originalRequest.newBuilder()
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .method(originalRequest.method(), originalRequest.body())
                    .build();
            return chain.proceed(requestWithHeaders);
        }
    }

}
