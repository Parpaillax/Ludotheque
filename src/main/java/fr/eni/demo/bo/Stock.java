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
  private Long dailyPrice;

  @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval = true)
  @JoinColumn(name="GAME_ID")
  private List<GameType> gameType;
}
