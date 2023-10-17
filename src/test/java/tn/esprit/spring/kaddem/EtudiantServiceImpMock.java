package tn.esprit.spring.kaddem;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.test.web.client.ExpectedCount;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.ExpectedCount.times;
import static tn.esprit.spring.kaddem.entities.Option.SIM;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class EtudiantServiceImpMock {
    @Mock
    EtudiantRepository etudiantRepository;

    @InjectMocks
    EtudiantServiceImpl etudiantService;

    Etudiant e1 = new Etudiant(1,"Ayari", "Abir",SIM);
    Etudiant e2 = new Etudiant(2,"Boussema", "Ahmed",SIM);

    List<Etudiant> listEtudiants = new ArrayList<Etudiant>() {{
        add(e1);
        add(e2);
        add(new Etudiant("Marzouki", "Rym"));
        add(new Etudiant("Ben Khalil", "Cyrine"));
    }};

    @Test
    public void testaddEtudiant(){
        Mockito.when(etudiantRepository.save(e1)).thenReturn(e1);
       Etudiant etudiant1 = etudiantService.addEtudiant(e1);
        //assertNotNull(produit1);
        Mockito.verify(etudiantRepository).save(Mockito.any(Etudiant.class));
    }

    @Test
    public void testretrieveAllEtudiants() {
        Mockito.when(etudiantRepository.findAll()).thenReturn(listEtudiants);
        List<Etudiant> listEtudiants1 = etudiantService.retrieveAllEtudiants();
        assertEquals(listEtudiants.size(), listEtudiants1.size());

    }
    @Test
    public void testupdateEtudiant(){
        Mockito.when(etudiantRepository.save(e2)).thenReturn(e2);
        Etudiant etudiant1 = etudiantService.updateEtudiant(e2);
        Mockito.verify(etudiantRepository).save(Mockito.any(Etudiant.class));
        //Mockito.verify(etudiantRepository,times(1)).save(Mockito.any(Etudiant.class));

    }

   /* @Test
    public void testdeleteEtudiant(){
        etudiantService.removeEtudiant(2);
        Mockito.verify(etudiantRepository).deleteById(2);
    }
*/









}
