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
@Document(collection = "game_type")
public class GameType {

  @Id
  private String id;

  @Field(name = "GAME_TYPE_NAME")
  private String name;
}
