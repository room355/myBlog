package room365.blog.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import room365.blog.app.model.Comment;
import room365.blog.app.model.Post;
import room365.blog.app.service.CommentService;
import room365.blog.app.service.PostService;

@RestController
public class PostController {
    final PostService postService;
    final CommentService commentService;
    @Autowired
    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public Page<Post> findAllPost(Pageable pageable) {
        return postService.findAllOrderedByDatePageable(pageable.getPageNumber());
    }

    @RequestMapping(value = "/post/{postId}/comments", method = RequestMethod.GET)
    public Page<Comment> findAllCommentByPostId(Pageable pageable, @PathVariable Long postId) {
        return commentService.findAllByPostId(pageable.getPageNumber(), postId);
    }

    @RequestMapping(value = "/post/{postId}/comment", method = RequestMethod.POST)
    public String saveCommentByPostId(@RequestBody Comment comment, @PathVariable Long postId) {
        commentService.saveByPostId(comment, postId);
        return "comment saved";
    }
}
