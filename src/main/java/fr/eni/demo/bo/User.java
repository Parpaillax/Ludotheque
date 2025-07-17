package fr.eni.demo.bo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "user")
public class User {

    @Id
    private String id;

    @Field(name = "USERNAME")
    private String username;

    @Field(name = "PASSWORD")
    private String password;

}
