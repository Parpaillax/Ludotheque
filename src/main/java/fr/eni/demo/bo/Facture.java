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
@ToString
@Builder

@Document(collection = "factures")
public class Facture {

  @Id
  private String id;

  @Field(name = "PRICE")
  private Double price;

  @Field(name = "DATEPAY")
  private Date datePay;

  @Field(name = "CLIENTS")
  private Client client;
}
