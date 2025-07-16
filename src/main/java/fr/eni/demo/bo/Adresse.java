package fr.eni.demo.bo;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "address")
public class Adresse {

  @Id
  private String id;

  @Field(name = "STREET")
  private String rue;

  @Field(name = "POSTAL_CODE")
  private String codePostal;

  @Field(name = "CITY")
  private String ville;

}