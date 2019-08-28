package me.shib.google.gsuite.chat.notifier;

import me.shib.google.gsuite.chat.notifier.models.request.Message;
import me.shib.google.gsuite.chat.notifier.models.response.MessageResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {

    @POST("v1/spaces/{spaceKey}/messages")
    Call<MessageResponse> sendMessage(@Path("spaceKey") String spaceKey, @Query("key") String key, @Query("token") String token, @Body Message message);

}
