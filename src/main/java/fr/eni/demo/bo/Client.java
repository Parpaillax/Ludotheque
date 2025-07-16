package fr.eni.demo.bo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "locations")
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
  @JoinColumn(name = "ADRESSE_ID")
  private Adresse adresse;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "CLIENT_ID")
  private List<Location> locations;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "CLIENT_ID")
  private List<Facture> factures;
}
