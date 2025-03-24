package com.api.rechub.repository;

import com.api.rechub.model.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ActiveProfiles("local")
public class UserRepoIT {
    @Autowired
    private UserRepo userRepo;

    //TODO: dont hardcode this uri
    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", () -> "mongodb+srv://kenharmon16:YmKkWPucAmrOFL8N@cluster0.knicbgf.mongodb.net/RecHub?retryWrites=true&w=majority&appName=Cluster0&ssl=true");
    }

    @Test
    public void testMongoConnection() {
        userRepo.findByEmail("testUser").ifPresent(user -> userRepo.delete(user));
        UserEntity user = new UserEntity("testUser", "testPassword");
        userRepo.save(user);

        assertThat(userRepo.findByEmail("testUser")).isPresent();
    }
}
