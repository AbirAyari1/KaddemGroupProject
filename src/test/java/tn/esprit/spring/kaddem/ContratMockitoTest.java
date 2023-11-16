package tn.esprit.spring.kaddem;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.ContratServiceImpl;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContratMockitoTest {

    @Mock
    private ContratRepository contratRepository;

    @Mock
    private EtudiantRepository etudiantRepository;

    @InjectMocks
    private ContratServiceImpl contratService;

    private Contrat contrat = new Contrat();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveAllContrats() {
        // Mocking the behavior of contratRepository.findAll()
        when(contratRepository.findAll()).thenReturn(Arrays.asList(contrat));

        List<Contrat> result = contratService.retrieveAllContrats();

        assertEquals(1, result.size());
        assertEquals(contrat, result.get(0));

        // Verify that contratRepository.findAll() was called once
        verify(contratRepository, times(1)).findAll();
    }

    @Test
    void testUpdateContrat() {
        // Mocking the behavior of contratRepository.save()
        when(contratRepository.save(any(Contrat.class))).thenReturn(contrat);

        Contrat result = contratService.updateContrat(contrat);

        assertEquals(contrat, result);

        // Verify that contratRepository.save() was called once with the specified argument
        verify(contratRepository, times(1)).save(contrat);
    }

    @Test
    void updateContrat() {
        // Arrange
        Contrat contrat = new Contrat();
        when(contratRepository.save(any())).thenReturn(contrat);

        // Act
        Contrat result = contratService.updateContrat(new Contrat());

        // Assert
        assertEquals(contrat, result);
    }

    @Test
    void addContrat() {
        // Arrange
        Contrat contrat = new Contrat();
        when(contratRepository.save(any())).thenReturn(contrat);

        // Act
        Contrat result = contratService.addContrat(new Contrat());

        // Assert
        assertEquals(contrat, result);
    }

    @Test
    void retrieveContrat() {
        // Arrange
        Contrat contrat = new Contrat();
        when(contratRepository.findById(any())).thenReturn(Optional.of(contrat));

        // Act
        Contrat result = contratService.retrieveContrat(1);

        // Assert
        assertEquals(contrat, result);
    }

    @Test
    void removeContrat() {
        // Arrange
        Contrat contrat = new Contrat();
        when(contratRepository.findById(any())).thenReturn(Optional.of(contrat));

        // Act
        contratService.removeContrat(1);

        // Assert
        verify(contratRepository, times(1)).delete(any());
    }

    @Test
    void affectContratToEtudiant() {
        // Arrange
        Etudiant etudiant = new Etudiant();
        Contrat contrat = new Contrat();
        Set<Contrat> con = new HashSet<Contrat>();
        con.add(new Contrat());
        etudiant.setContrats(con);
        when(etudiantRepository.findByNomEAndPrenomE(any(), any())).thenReturn(etudiant);
        when(contratRepository.findByIdContrat(any())).thenReturn(contrat);
        when(contratRepository.save(any())).thenReturn(contrat);

        // Act
        Contrat result = contratService.affectContratToEtudiant(1, "John", "Doe");

        // Assert
        assertEquals(contrat, result);
    }
}
