package com.example.elegant_touch.Account;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface apiset {

    @FormUrlEncoded
    @POST("register.php")
    Call<signup_response_mode> getregister(
      @Field("name") String name,
      @Field("email") String email,
      @Field("mobile") String mobile,
      @Field("password") String password,
      @Field("address") String address
    );

}
