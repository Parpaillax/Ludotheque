package fr.eni.demo.bo;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

@Entity
@Table(name="GAME")
public class Stock {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "GAME_ID")
  private Integer id;

  @Column(name="GAME_NAME", nullable = false)
  private String name;

  @Column(name="GAME_DESCRIPTION")
  private String description;

  @Column(name="GAME_REF", nullable = false)
  private String ref;

  @Column(name="GAME_DAILY_PRICE", nullable = false)
  private Double dailyPrice;

  @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinTable(
    name = "STOCK_GAME_TYPE",
    joinColumns = @JoinColumn(name = "GAME_ID"),         // Clé étrangère vers Stock
    inverseJoinColumns = @JoinColumn(name = "GAME_TYPE_ID") // Clé étrangère vers GameType
  )
  private List<GameType> gameType;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "GAME_ID")
  private List<Location> locations;
}
