package tn.esprit.spring.kaddem;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.client.ExpectedCount.times;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class EtudiantServiceImpMock {
    @Mock
    EtudiantRepository etudiantRepository;

    @InjectMocks
    EtudiantServiceImpl etudiantService;

    Etudiant e1 = new Etudiant("Ayari", "Abir");
    Etudiant e2 = new Etudiant("Boussema", "Ahmed");

    List<Etudiant> listEtudiants = new ArrayList<Etudiant>() {{
        add(e1);
        add(new Etudiant("XX", "XXX"));
        add(new Etudiant("eXX", "XXeeeX"));
    }};

    @Test
    public void testaddEtudiant(){
        Mockito.when(etudiantRepository.save(e1)).thenReturn(e1);
       Etudiant etudiant1 = etudiantService.addEtudiant(e1);
        //assertNotNull(produit1);
        Mockito.verify(etudiantRepository).save(Mockito.any(Etudiant.class));
        System.out.println("3");
    }
}
