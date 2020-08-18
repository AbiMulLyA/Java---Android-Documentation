package repository.services;

import repository.models.RepoModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import java.util.List;

public interface GitHubService {
    @GET("users/{user}/repos")
    Call<List<RepoModel>> getRepos(@Path("user") String user);
}
