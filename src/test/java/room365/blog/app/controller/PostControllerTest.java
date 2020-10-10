package room365.blog.app.controller;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import room365.blog.app.model.Post;
import room365.blog.app.object.PostResponse;
import room365.blog.app.service.CommentService;
import room365.blog.app.service.PostService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PostController.class)
class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @MockBean
    private CommentService commentService;

    private List<Post> posts;
    private Gson gson;
    Logger logger = LoggerFactory.getLogger(PostControllerTest.class);

    @BeforeEach
    void setUp() {
        this.posts = new ArrayList<>();
        posts.add(new Post(1L, "title1", "body1", new Date()));
        posts.add(new Post(2L, "title2", "body2", new Date()));
        posts.add(new Post(3L, "title3", "body3", new Date()));
        posts.add(new Post(4L, "title4", "body4", new Date()));
        gson = new Gson();
    }

    @Test
    void shouldFetchAllPosts() throws Exception {
        given(postService.findAllOrderedByDatePageable(0)).willReturn(new PageImpl<>(posts));
        MvcResult res =  this.mockMvc.perform(get("/post"))
                                     .andExpect(status().isOk())
                                     .andReturn();
        String content = res.getResponse().getContentAsString();
        logger.info("Received mock content: {}" ,content);
        PostResponse postPage = gson.fromJson(content, PostResponse.class);
        List<Post> postList = postPage.getContent();
        for (int i = 0; i < postList.size(); i++) {
            assertEquals(postList.get(i).getId(), posts.get(i).getId());
            assertEquals(postList.get(i).getTitle(), posts.get(i).getTitle());
            assertEquals(postList.get(i).getBody(), posts.get(i).getBody());
        }
    }
}