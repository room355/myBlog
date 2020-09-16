package room365.blog.app.service;

import org.springframework.data.domain.Page;
import room365.blog.app.model.Post;

import java.util.Optional;

public interface PostService {
    public Optional<Post> findById(Long id);
    public Post save(Post post);
    public Page<Post> findAllOrderedByDatePageable(int page);
    public void delete(Post post);
}
