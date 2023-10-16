package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;
import tn.esprit.spring.kaddem.services.IEtudiantService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EtudiantServiceImpJunit {
    @Autowired
    IEtudiantService etudiantService;

    @Autowired
    EtudiantRepository etudiantRepository;

    Etudiant e1 = new Etudiant("Ayari", "Abir");
    Etudiant e2 = new Etudiant("Boussema", "Ahmed");
    @Test
    @Order(1)
    public void testaddEtudiantt() {
        Etudiant etudiantAdded = etudiantService.addEtudiant(e1);
        Assertions.assertEquals(etudiantAdded.getIdEtudiant(), etudiantAdded.getIdEtudiant());
    }

}
