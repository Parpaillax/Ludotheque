package fr.eni.demo.bo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "clients")
public class Client {

  @Id
  private String id;

  @Field(name = "LAST_NAME")
  private String nom;

  @Field(name = "FIRST_NAME")
  private String prenom;

  @Field(name = "EMAIL")
  private String email;

  @Field(name = "ADRESSE")
  private Adresse adresse;

  @Field(name = "LOCATIONS")
  private List<Location> locations;

  @Field(name = "FACTURES")
  private List<Facture> factures;
}
