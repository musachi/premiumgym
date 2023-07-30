package com.premium.premiumgym.exercise;

import com.premium.premiumgym.zconfig.ConstantValues;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest(TargetController.class)
public class TargetControllerTest {

    @Mock
    private TargetService myServiceMock;

    @InjectMocks
    private TargetController myController;

    @Test
    public void TargetControllerTest() {
        MockitoAnnotations.openMocks(this);

        List<Target> models = Target.generateTargets();

        when(myServiceMock.findAll()).thenReturn(models);

        ResponseEntity<List<Target>> responseEntity = new ResponseEntity<>(myController.getTargets(), HttpStatus.OK);
        assertEquals(models, responseEntity.getBody());
    }

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() {
            mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void testGetTargets() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(ConstantValues.TARGETS)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        assertEquals(Target.generateTargets().toString(), result.getResponse().toString());
    }
}
