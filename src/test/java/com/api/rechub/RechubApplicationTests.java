package com.api.rechub;

import com.api.rechub.configuration.RestTemplateConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ActiveProfiles("test")
class RechubApplicationTests {

	@Test
	void contextLoads() {
	}

}
