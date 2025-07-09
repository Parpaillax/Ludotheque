package fr.eni.demo.bo;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"client", "stock"})
@Builder

@Entity
@Table(name="LOCATIONS")
public class Location {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="LOCATION_ID")
  private Integer id;

  @Column(name = "LOCATION_START_DATE", nullable = false)
  private Date startDate;

  @Column(name = "LOCATION_END_DATE")
  private Date endDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CLIENT_ID", nullable = false)
  private Client client;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "GAME_ID", nullable = false)
  private Stock stock;
}
