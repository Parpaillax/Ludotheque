package fr.eni.demo.bo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "stock")
public class Stock {

  @Id
  private String id;

  @Field(name = "GAME_NAME")
  private String name;

  @Field(name = "GAME_DESCRIPTION")
  private String description;

  @Field(name = "GAME_REF")
  private String ref;

  @Field(name = "GAME_DAILY_PRICE")
  private Double dailyPrice;

  @Field(name = "GAME_IS_RENT")
  private Boolean isRent;

  @Field(name = "GAME_TYPE")
  private List<GameType> gameType;

  @Field(name = "LOCATIONS")
  private List<Location> locations;
}

