package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;
import tn.esprit.spring.kaddem.services.UniversiteServiceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UniversiteMockTest {

    @InjectMocks
    private UniversiteServiceImpl universiteService;

    @Mock
    private UniversiteRepository universiteRepository;

    @Mock
    private DepartementRepository departementRepository;

    @Test
    void retrieveAllUniversitesTest() {
        List<Universite> universites = new ArrayList<>();
        universites.add(new Universite());
        when(universiteRepository.findAll()).thenReturn(universites);
        List<Universite> result = universiteService.retrieveAllUniversites();
        assertEquals(universites, result);
    }

    @Test
    void addUniversiteTest() {
        Universite universite = new Universite();
        when(universiteRepository.save(Mockito.any(Universite.class))).thenReturn(universite);
        Universite result = universiteService.addUniversite(universite);
        assertNotNull(result);
    }

    @Test
    void updateUniversiteTest() {
        Universite universite = new Universite();
        when(universiteRepository.save(Mockito.any(Universite.class))).thenReturn(universite);
        Universite result = universiteService.updateUniversite(universite);
        assertNotNull(result);
    }

    @Test
    void retrieveUniversiteTest() {
        Integer idUniversite = 1;
        Universite universite = new Universite();
        when(universiteRepository.findById(idUniversite)).thenReturn(Optional.of(universite));
        Universite result = universiteService.retrieveUniversite(idUniversite);
        assertEquals(universite, result);
    }

    @Test
    void deleteUniversiteTest() {
        Integer idUniversite = 1;
        Universite universite = new Universite();
        when(universiteRepository.findById(idUniversite)).thenReturn(Optional.of(universite));
        universiteService.deleteUniversite(idUniversite);
        verify(universiteRepository, times(1)).delete(universite);
    }
}
