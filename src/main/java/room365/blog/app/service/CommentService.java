package room365.blog.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import room365.blog.app.model.Comment;

import java.util.Optional;

public interface CommentService {
    public Optional<Comment> saveByPostId(Comment comment, Long postId);
    public Page<Comment> findAllByPostId(int page, Long Id);
}
