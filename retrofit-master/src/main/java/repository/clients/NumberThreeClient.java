package repository.clients;

import repository.services.PostsService;
import repository.services.UsersService;
import utils.ConstantUtil;

public class NumberThreeClient {

    public static UsersService usersService() {
        return APIClient.client(
                UsersService.class,
                ConstantUtil.baseURLNumberThree
        );
    }

    public static PostsService postsService() {
        return APIClient.client(
                PostsService.class,
                ConstantUtil.baseURLNumberThree
        );
    }
}
