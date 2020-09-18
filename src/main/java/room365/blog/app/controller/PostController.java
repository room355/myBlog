package room365.blog.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import room365.blog.app.model.Post;
import room365.blog.app.service.PostService;

@RestController
public class PostController {
    PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public Page<Post> findAllPost(Pageable pageable) {
        return postService.findAllOrderedByDatePageable(pageable.getPageNumber());
    }
}
