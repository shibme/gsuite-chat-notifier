package me.shib.google.gsuite.chat.notifier;

import com.google.gson.Gson;
import me.shib.google.gsuite.chat.notifier.models.request.Message;
import me.shib.google.gsuite.chat.notifier.models.response.MessageResponse;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

public final class GSuiteChatNotifier {

    private static final transient Gson gson = new Gson();

    private API api;
    private String spaceKey;
    private String key;
    private String token;

    public GSuiteChatNotifier(String webhookURL) throws MalformedURLException, GSuiteChatException, UnsupportedEncodingException {
        WebhookUrlBuilder webhookUrlBuilder = new WebhookUrlBuilder(webhookURL);
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
        this.api = retrofit.create(API.class);
    }

    public MessageResponse sendMessage(Message message) throws GSuiteChatException {
        try {
            Response<MessageResponse> response = api.sendMessage(spaceKey, key, token, message).execute();
            MessageResponse messageResponse = response.body();
            if (response.code() == 200 && messageResponse != null) {
                return messageResponse;
            }
            if (response.errorBody() != null) {
                Object error = gson.fromJson(response.errorBody().string(), Object.class);
                throw new GSuiteChatException(gson.toJson(error));
            }
            throw new GSuiteChatException("Unknown Error Occurred!");
        } catch (IOException e) {
            throw new GSuiteChatException(e.getMessage());
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
