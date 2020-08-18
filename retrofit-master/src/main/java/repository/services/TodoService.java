package repository.services;

import repository.models.BaseTodoModel;
import repository.models.TodoModel;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface TodoService {
    @GET("v1/todos")
    Call<BaseTodoModel<List<TodoModel>>> getTodos();

    @GET("v1/todos/{id}")
    Call<BaseTodoModel<TodoModel>> getTodo(@Path("id") int id);

    @Headers("Content-Type: application/json")
    @POST("v1/todos")
    Call<BaseTodoModel<TodoModel>> addTodos(@Body TodoModel todoModel);

    @Headers("Content-Type: application/json")
    @PUT("v1/todos/{id}")
    Call<BaseTodoModel<String>> updateTodos(@Path("id") int id, @Body TodoModel todoModel);

    @DELETE("v1/todos/{id}")
    Call<BaseTodoModel<String>> deleteTodo(@Path("id") int id);
}
