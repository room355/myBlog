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
import room365.blog.app.model.User;
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
        getPostList(4);
        gson = new Gson();
    }

    private void getPostList(int c) {
        this.posts = new ArrayList<>();
        User user = new User();
        user.setId(1l);
        for (int i = 1; i <= c; i++) {
            Post p = new Post();
            p.setId((long) i);
            p.setTitle("title" + i);
            p.setBody("body" + i);
            p.setCreateDate(new Date());
        }
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