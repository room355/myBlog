package room365.blog.app.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import room365.blog.app.model.Comment;
import room365.blog.app.model.Post;
import room365.blog.app.repository.CommentRepository;
import room365.blog.app.repository.PostRepository;
import room365.blog.app.service.CommentService;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public Optional<Comment> saveByPostId(Comment comment, Long postId) {
        // get Post by post ID
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            logger.info("Post is present");
            comment.setPost(optionalPost.get());
        } else {
            logger.info("Post not found");
            return Optional.empty();
        }
        Optional<Comment> optionalComment = Optional.of(commentRepository.save(comment));
        return optionalComment;
    }

    @Override
    public Page<Comment> findAllByPostId(int page, Long postId) {
        return commentRepository.findAllByPostId(PageRequest.of(page, 5), postId);
    }
}
