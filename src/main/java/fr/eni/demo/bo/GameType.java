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
@Table(name="GAME_TYPE")
public class GameType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "GAME_TYPE_ID")
  private Integer id;

  @Column(name="GAME_TYPE_NAME", nullable = false)
  private String name;
}
