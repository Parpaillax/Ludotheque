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
@Table(name="CLIENTS")
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CLIENT_ID")
  private Integer id;

  @Column(name= "LAST_NAME", nullable = false, length = 90)
  private String nom;

  @Column(name= "FIRST_NAME", nullable = false, length = 150)
  private String prenom;

  @Column(nullable = false, unique = true)
  private String email;

  @OneToOne(cascade =  CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "LOCATION_ID")
  private Location location;
}
