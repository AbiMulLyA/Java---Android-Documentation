package repository.clients;

import repository.services.GitHubService;

public class GitHubClient {
    public static GitHubService gitHubService() {
        return APIClient.client(
                GitHubService.class,
                "https://api.github.com/"
        );
    }
}
