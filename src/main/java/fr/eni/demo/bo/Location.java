package fr.eni.demo.bo;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

@Entity
@Table(name="LOCATIONS")
public class Location {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "LOCATION_ID")
  private Integer id;

  @Column(name = "STREET",nullable = false, length = 250)
  private String rue;

  @Column(name = "POSTAL_CODE",nullable = false, length = 5)
  private String codePostal;

  @Column(name = "CITY",nullable = false, length = 150)
  private String ville;

}