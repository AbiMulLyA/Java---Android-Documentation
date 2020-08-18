package repository.services;

import repository.models.UsersModel;
import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface UsersService {
    @GET("users")
    Call<List<UsersModel>> getUsers();
}
