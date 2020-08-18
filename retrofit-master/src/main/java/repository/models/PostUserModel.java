package repository.models;

public class PostUserModel extends PostsModel {
    UsersModel user;

    public PostUserModel(PostsModel post) {
        super(post.getUserId(), post.getId(), post.getTitle(), post.getBody());
    }

    public UsersModel getUser() {
        return user;
    }

    public void setUser(UsersModel user) {
        this.user = user;
    }
}
