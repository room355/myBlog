package room365.blog.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import room365.blog.app.model.Comment;
import room365.blog.app.repository.CommentRepository;
import room365.blog.app.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Page<Comment> findAllByPostId(int page, Long postId) {
        return commentRepository.findAllByPostId(PageRequest.of(page, 5), postId);
    }
}
