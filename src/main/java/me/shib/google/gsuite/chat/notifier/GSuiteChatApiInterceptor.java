package me.shib.google.gsuite.chat.notifier;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

final class GSuiteChatApiInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request requestWithHeaders = originalRequest.newBuilder()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .method(originalRequest.method(), originalRequest.body())
                .build();
        return chain.proceed(requestWithHeaders);
    }
}