package rgo.cloud.common.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@TestConfiguration
public class WebTest extends PersistenceTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private FilterChainProxy filter;

    protected MockMvc mvc;

    public void initMvc() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    public void initSecurityMvc() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilter(filter)
                .build();
    }
}
