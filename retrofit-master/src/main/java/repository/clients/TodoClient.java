package repository.clients;

import repository.services.TodoService;
import utils.ConstantUtil;

public class TodoClient {
    public static TodoService todoService() {
        return APIClient.client(
                TodoService.class,
                ConstantUtil.baseURLNumberTwo
        );
    }
}
