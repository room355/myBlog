package room365.blog.app.object;

import room365.blog.app.model.Post;

import java.util.List;

public class PostResponse {
    private List<Post> content;
    public List<Post> getContent() {
        return content;
    }

    public void setContent(List<Post> content) {
        this.content = content;
    }
}
