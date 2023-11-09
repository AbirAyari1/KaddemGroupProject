package tn.esprit.spring.kaddem;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class EquipeServiceImpMOC {
    @Mock
    EquipeRepository equipeRepository;

    @InjectMocks
    EquipeServiceImpl equipeService;

    Equipe eq1 = new Equipe(1,"emna", Niveau.EXPERT);
    Equipe eq2 = new Equipe(2,"bejaoui", Niveau.SENIOR);

    List<Equipe> listEquipes = new ArrayList<Equipe>() {{
        add(eq1);
        add(eq2);
        add(new Equipe("ma", Niveau.SENIOR));
        add(new Equipe("chems", Niveau.SENIOR));
    }};

    @Test
    public void testaddEquipe(){
        Mockito.when(equipeRepository.save(eq1)).thenReturn(eq1);
        Equipe equipe1 = equipeService.addEquipe(eq1);
        //assertNotNull(produit1);
        Mockito.verify(equipeRepository).save(Mockito.any(Equipe.class));
    }

    @Test
    public void testretrieveAllEquipes() {
        Mockito.when(equipeRepository.findAll()).thenReturn(listEquipes);
        List<Equipe> listEquipes1 = equipeService.retrieveAllEquipes();
        assertEquals(listEquipes.size(), listEquipes1.size());

    }
    @Test
    public void testupdateEquipe() {
        Mockito.when(equipeRepository.save(eq2)).thenReturn(eq2);
        Equipe equipe1 = equipeService.updateEquipe(eq2);
        Mockito.verify(equipeRepository).save(Mockito.any(Equipe.class));
        //Mockito.verify(etudiantRepository,times(1)).save(Mockito.any(Etudiant.class));

    }}


