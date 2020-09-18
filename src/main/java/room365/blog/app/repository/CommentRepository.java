package room365.blog.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import room365.blog.app.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findAllByPostId(Pageable pageable, Long postId);
}
