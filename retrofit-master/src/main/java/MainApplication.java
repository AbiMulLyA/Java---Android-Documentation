import repository.clients.NumberThreeClient;
import repository.clients.TodoClient;
import repository.clients.UserClient;
import repository.models.PostUserModel;
import repository.models.TodoModel;
import repository.models.UserModel;
import utils.JsonUtil;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class MainApplication {
    public static void main(String[] args) {
//        numberOne();
//        numberTwo();
//        numberThree();
    }

    private static void numberThree() {
        var postsClient = NumberThreeClient.postsService();
        var usersClient = NumberThreeClient.usersService();

        // 1
        try {
            System.out.println("Nomor satu\n");

            // 1
            var posts = postsClient.getPosts().execute().body();
            System.out.println("POSTS:\n");
            System.out.println(JsonUtil.toJson(posts));

            // 2
            var users = usersClient.getUsers().execute().body();
            System.out.println("\nUSERS:\n");
            System.out.println(JsonUtil.toJson(users));

            // 3
            System.out.println("\nPOST USERS:\n");
            var postUsers = (users != null && posts != null) ?
                    posts.stream().map(value -> {
                        var postUser = new PostUserModel(value);
                        var user = users.stream()
                                .filter(it -> it.getId() == value.getUserId())
                                .findFirst()
                                .orElse(null);
                        postUser.setUser(user);

                        return postUser;
                    }).collect(Collectors.toList()) :
                    List.of();

            postUsers.forEach(it -> System.out.println(JsonUtil.toJson(it)));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.exit(0);
    }

    private static void numberTwo() {
        var numberTwoClient = TodoClient.todoService();

        // 1
        try {
            System.out.println("Nomor satu\n");
            var response = numberTwoClient
                    .getTodos()
                    .execute();
            if (response.isSuccessful()) {
                // a
                var json = JsonUtil.toJson(response.body());
                var fos = new FileOutputStream("src/main/java/todos.json");
                fos.write(json.getBytes());
                fos.flush();
                fos.close();

                // b
                var list = response.body();
                var data = (list != null) ?
                        list.getData().stream().map(value -> {
                            var formatter = DateTimeFormatter
                                    .ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                                    .withZone(ZoneId.of("UTC"));
                            var date = LocalDateTime
                                    .parse(value.getCreatedAt(), formatter);
                            var localFormatter = DateTimeFormatter
                                    .ofPattern(
                                            "EEEE, dd MMMM yyyy",
                                            new Locale("id", "ID")
                                    );
                            var localDate = date.format(localFormatter);
                            var status = value.isStatus() ?
                                    "sudah dikerjakan." :
                                    "belum selesai dikerjakan";

                            return "Tugas " + value.getTask() + " pada " +
                                    localDate + " " + status;
                        }).collect(Collectors.toList()) :
                        List.of();
                data.forEach(it -> System.out.println(JsonUtil.toJson(it)));
            } else {
                System.out.println(response.message());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // 2
        try {
            System.out.println("\nNomor dua\n");
            var response = numberTwoClient
                    .getTodo(42)
                    .execute();
            if (response.isSuccessful()) {
                System.out.println(JsonUtil.toJson(response.body()));
            } else {
                System.out.println(response.message());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // 3
        try {
            System.out.println("\nNomor tiga\n");
            var todoModel = new TodoModel();
            todoModel.setTask("Review HTTP Request Exercises");
            var response = numberTwoClient
                    .addTodos(todoModel)
                    .execute();
            if (response.isSuccessful()) {
                System.out.println(JsonUtil.toJson(response.body()));
            } else {
                System.out.println(response.message());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // 4
        try {
            System.out.println("\nNomor empat\n");
            var todoModel = new TodoModel();
            todoModel.setId(49);
            todoModel.setTask("HTTP Request Exercises");
            todoModel.setStatus(true);
            var response = numberTwoClient
                    .updateTodos(todoModel.getId(), todoModel)
                    .execute();
            if (response.isSuccessful()) {
                System.out.println(JsonUtil.toJson(response.body()));
            } else {
                System.out.println(response.message());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // 5
        try {
            System.out.println("\nNomor lima\n");
            var todoModel = new TodoModel();
            todoModel.setId(51);
            var response = numberTwoClient
                    .deleteTodo(todoModel.getId())
                    .execute();
            if (response.isSuccessful()) {
                System.out.println(JsonUtil.toJson(response.body()));
            } else {
                System.out.println(response.message());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.exit(0);
    }

    private static void numberOne() {
        var numberOneClient = UserClient.userService();

        // 1
        try {
            System.out.println("Nomor satu\n");
            var response = numberOneClient
                    .getUsers(1)
                    .execute();
            if (response.isSuccessful()) {
                System.out.println(JsonUtil.toJson(response.body()));
            } else {
                System.out.println(response.message());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // 2
        try {
            System.out.println("\nNomor dua\n");
            var response = numberOneClient
                    .getUserById(1)
                    .execute();
            if (response.isSuccessful()) {
                System.out.println(JsonUtil.toJson(response.body()));
            } else {
                System.out.println(response.message());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // 3
        try {
            System.out.println("\nNomor tiga\n");
            var userModel = new UserModel();
            userModel.setName("morpheus");
            userModel.setJob("leader");
            var response = numberOneClient
                    .addUser(userModel)
                    .execute();
            if (response.isSuccessful()) {
                System.out.println(JsonUtil.toJson(response.body()));
            } else {
                System.out.println(response.message());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // 4
        try {
            System.out.println("\nNomor empat\n");
            var userModel = new UserModel();
            userModel.setId(1);
            userModel.setName("morpheus");
            userModel.setJob("zion resident");
            var response = numberOneClient
                    .putUser(userModel.getId(), userModel)
                    .execute();
            if (response.isSuccessful()) {
                System.out.println(JsonUtil.toJson(response.body()));
            } else {
                System.out.println(response.message());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // 5
        try {
            System.out.println("\nNomor lima\n");
            var userModel = new UserModel();
            userModel.setId(10);
            userModel.setName("morpheus");
            userModel.setJob("zion resident");
            var response = numberOneClient
                    .patchUser(userModel.getId(), userModel)
                    .execute();
            if (response.isSuccessful()) {
                System.out.println(JsonUtil.toJson(response.body()));
            } else {
                System.out.println(response.message());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // 6
        try {
            System.out.println("\nNomor enam\n");
            var id = 10;
            var response = numberOneClient
                    .deleteUserById(id)
                    .execute();
            if (response.isSuccessful()) {
                System.out.println("User dengan id " + id + " berhasil dihapus");
            } else {
                System.out.println(response.message());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.exit(0);
    }
}
