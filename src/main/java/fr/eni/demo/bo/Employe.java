package fr.eni.demo.bo;

import jakarta.persistence.*;
import lombok.*;

//@Data
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of= {"immatriculation"})
@ToString
//@Builder

@Entity
@Table(name="EMPLOYES")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private Integer id;

    @Column(name= "LAST_NAME", nullable = false, length = 90)
    private String nom;

    @Column(name= "FIRST_NAME", nullable = false, length = 150)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name= "EMPLOYE_REGISTRATION", nullable = false, unique = true, length = 100)
    private String immatriculation;

    @Column(name= "HOME_PHONE_NUMBER", nullable = false, length = 12)
    private String numDom;

    @Column(name= "PHONE_NUMBER", nullable = false, length = 12)
    private String numPortable;
}
