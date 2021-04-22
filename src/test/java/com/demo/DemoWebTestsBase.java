package com.demo;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class DemoWebTestsBase {
	
    @Autowired
    protected WebApplicationContext webApplicationContext;
    
    protected MockMvc mockClient;

    @Before
    public void setupRestClient() throws Exception {
        this.mockClient = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

}
