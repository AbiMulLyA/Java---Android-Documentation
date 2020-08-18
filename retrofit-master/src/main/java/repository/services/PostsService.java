package repository.services;

import repository.models.PostsModel;
import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface PostsService {
    @GET("posts")
    Call<List<PostsModel>> getPosts();
}
