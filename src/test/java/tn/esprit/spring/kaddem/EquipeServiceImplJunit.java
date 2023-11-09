package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.IEquipeService;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EquipeServiceImplJunit {
    @Autowired
    IEquipeService equipeService;

    @Autowired
    EquipeRepository equipeRepository;

    Equipe eq1 = new Equipe(1,"emna", Niveau.EXPERT);
    Equipe eq2 = new Equipe(2,"bejaoui", Niveau.SENIOR);
    @Test
    @Order(1)
    public void testaddEquipe() {
        Equipe equipeAdded = equipeService.addEquipe(eq1);
        Assertions.assertEquals(eq1.getIdEquipe(), equipeAdded.getIdEquipe());
    }
    @Test
    @Order(2)
    public void testRetrieveAllEquipes() {
        List<Equipe> listEquipes = equipeService.retrieveAllEquipes();
        // Assertions.assertEquals(4, listEtudiants.size());
        Assertions.assertEquals(listEquipes.size(), listEquipes.size());
    }

    @Test
    @Order(3)
    public void testRetrieveEquipe() {
        Equipe equipeRetrieved = equipeService.retrieveEquipe(6);
        Assertions.assertNotNull(equipeRetrieved);
        Assertions.assertEquals(6, equipeRetrieved.getIdEquipe().longValue());
    }

    @Test
    @Order(3)
    public void testModifyEquipe()   {
        eq1.setNomEquipe("emna");
        Equipe equipeUpdated = equipeService.updateEquipe(eq1);
        Assertions.assertNotNull(equipeUpdated);
        Assertions.assertEquals(eq1.getNomEquipe(), equipeUpdated.getNomEquipe());
    }


}



