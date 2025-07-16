package fr.eni.demo.bo;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

@Entity
@Table(name="Facture")
public class Facture {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "FACTURE_ID")
  private Long id;

  @Column(name = "PRICE")
  private Double price;

  @Column(name = "DATE_PAY")
  private Date datePay;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "CLIENT_ID", nullable = false)
  private Client client;
}
