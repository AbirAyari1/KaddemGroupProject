package tn.esprit.spring.kaddem.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.spring.kaddem.entities.Departement;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UniversiteDTO {
    Integer idUniv;
    String nomUniv;
    Set<Departement> departements;
}
