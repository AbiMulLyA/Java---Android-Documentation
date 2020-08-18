package repository.services;

import repository.models.BaseUserModel;
import repository.models.UserModel;
import retrofit2.Call;
import retrofit2.http.*;
import java.util.List;

public interface UserService {
    @GET("users")
    Call<BaseUserModel<List<UserModel>>> getUsers(@Query("page") int page);

    @GET("users/{id}")
    Call<BaseUserModel<UserModel>> getUserById(@Path("id") int id);

    @Headers("Content-Type: application/json")
    @POST("users")
    Call<UserModel> addUser(@Body UserModel userModel);

    @Headers("Content-Type: application/json")
    @PUT("users/{id}")
    Call<UserModel> putUser(@Path("id") int id, @Body UserModel userModel);

    @Headers("Content-Type: application/json")
    @PATCH("users/{id}")
    Call<UserModel> patchUser(@Path("id") int id, @Body UserModel userModel);

    @DELETE("users/{id}")
    Call<Void> deleteUserById(@Path("id") int id);
}
