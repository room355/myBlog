package room365.blog.app.exception;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(Long postId) {
        super("Post: " + String.valueOf(postId) + " Not Found");
    }
}
