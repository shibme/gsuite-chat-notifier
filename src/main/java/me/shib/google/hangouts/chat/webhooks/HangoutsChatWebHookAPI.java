package me.shib.google.hangouts.chat.webhooks;

import me.shib.google.hangouts.chat.webhooks.models.request.Message;
import me.shib.google.hangouts.chat.webhooks.models.response.MessageResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

interface HangoutsChatWebHookAPI {

    @POST("v1/spaces/{spaceKey}/messages")
    Call<MessageResponse> sendMessage(@Path("spaceKey") String spaceKey, @Query("key") String key, @Query("token") String token, @Body Message message);

}
