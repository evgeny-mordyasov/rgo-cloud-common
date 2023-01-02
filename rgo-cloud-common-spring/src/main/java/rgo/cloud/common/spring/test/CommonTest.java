package rgo.cloud.common.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;

import static rgo.cloud.common.spring.util.TestCommonUtil.runScript;

@TestConfiguration
public class CommonTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    protected MockMvc mvc;

    @Autowired
    private DataSource h2;

    public void truncateTables() {
        runScript("h2/truncate.sql", h2);
    }

    public void initMvc() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
}
