package repository.clients;

import repository.services.UserService;
import utils.ConstantUtil;

public class UserClient {
    public static UserService userService() {
        return APIClient.client(UserService.class, ConstantUtil.baseURLNumberOne);
    }
}
