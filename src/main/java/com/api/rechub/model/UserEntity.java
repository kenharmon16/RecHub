package com.api.rechub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Users")
@Getter
@Setter
@RequiredArgsConstructor
public class UserEntity {

    @Id
    private String id;
    @NonNull
    private String email;
    @NonNull
    private String password;
}
