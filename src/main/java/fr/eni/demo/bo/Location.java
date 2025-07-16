package fr.eni.demo.bo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "locations")
public class Location {

  @Id
  private String id;

  @Field(name = "CODE_BARRE")
  private String codeBarre;

  @Field(name = "LOCATION_START_DATE")
  private Date startDate;

  @Field(name = "LOCATION_END_DATE")
  private Date endDate;

  @Field(name = "CLIENT")
  private Client client;

  @Field(name = "STOCK")
  private Stock stock;
}
