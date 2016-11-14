package examen;

import examen.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by jbaez on 13/11/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebIntegrationTest({"server.port=8181"})
public class MenuControllerIT {

    private static final Long INFO_ID_1 = 1l;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(this.webApplicationContext)
                .build();
    }

    @Test
    public void getMenu_ShouldReturnCorrectInfo() throws Exception {
        String jsonExpected = "{\"id\":1,\"name\":\"Spaguetti con salsa Bolognesa\",\"description\":\"Fideos acompañados por una suave salsa bolgnesa.\",\"price\":89.50,\"currency\":{\"id\":2,\"name\":\"Peso\",\"symbol\":\"$\"},\"fromValidDate\":\"2016-01-01\",\"toValidDate\":\"2016-06-30\",\"days\":[\"monday\",\"tuesday\",\"wednesday\",\"thursday\",\"friday\"],\"fromHour\":12,\"fromMinute\":20,\"toHour\":16,\"toMinute\":0,\"ranking\":4.9,\"pictureFile\":\"food-picture-01.jpg\"}";

        mockMvc.perform(get("/menu/{id}", INFO_ID_1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().string(jsonExpected));
    }

    @Test
    public void getMenu_MenuFound_ShouldReturnCorrectInfo() throws Exception {
        mockMvc.perform(get("/menu/{id}", INFO_ID_1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(INFO_ID_1.intValue())))
                .andExpect(jsonPath("$.name", is("Spaguetti con salsa Bolognesa")))
                .andExpect(jsonPath("$.price", is(notNullValue())));
    }

    @Test
    public void getMenu_InfoFound_ShouldReturnCorrectFilteredMenu() throws Exception {
        mockMvc.perform(get("/menu/?day=monday"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.content", hasSize(2)))
                .andExpect(jsonPath("$.content[0].name", is("Asado")));
    }

    @Test
    public void getMenu_InfoFound_ShouldReturnCorrectOrderedId() throws Exception {
        ResultActions get = mockMvc.perform(get("/menu/?day=monday"));
        get.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.content", hasSize(2)))
                .andExpect(jsonPath("$.content[0].id",greaterThan(1)));

    }

    @Test
    public void getMenu_InfoFound_ShouldReturnCorrectNumberOfContent() throws Exception {
        ResultActions get = mockMvc.perform(get("/menu/?day=nada"));
        get.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.content", hasSize(0)));


    }
}
