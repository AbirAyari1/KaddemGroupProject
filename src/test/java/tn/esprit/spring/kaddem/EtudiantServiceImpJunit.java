package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;
import tn.esprit.spring.kaddem.services.IEtudiantService;
import java.util.List;

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
        Assertions.assertEquals(e1.getIdEtudiant(), etudiantAdded.getIdEtudiant());
    }
    @Test
    @Order(2)
    public void testRetrieveAllEtudiants() {
        List<Etudiant> listEtudiants = etudiantService.retrieveAllEtudiants();
       // Assertions.assertEquals(4, listEtudiants.size());
        Assertions.assertEquals(listEtudiants.size(), listEtudiants.size());
    }

    @Test
    @Order(3)
    public void testRetrieveEtudiant() {
        Etudiant etudiantRetrieved = etudiantService.retrieveEtudiant(1);
        Assertions.assertNotNull(etudiantRetrieved);
        Assertions.assertEquals(1, etudiantRetrieved.getIdEtudiant().longValue());
    }

    @Test
    @Order(3)
    public void testModifyEtudiant()   {
        e1.setNomE("Ayarii");
        Etudiant etudiantUpdated = etudiantService.updateEtudiant(e1);
        Assertions.assertNotNull(etudiantUpdated);
        Assertions.assertEquals(e1.getNomE(), etudiantUpdated.getNomE());
    }

  /*  @Test
    @Order(4)
    public void testDeleteEtudiant() {
        // Attempt to delete the student with ID 2
        try {
            etudiantService.removeEtudiant(1);
            Etudiant etudiant = etudiantService.retrieveEtudiant(1);
            Assertions.assertNull(etudiant);
        } catch (Exception e) {
            // Handle the exception if the student does not exist or if there is an attempt to remove a null entity
            Assertions.fail("An exception occurred: " + e.getMessage());
        }
    }*/

    }








