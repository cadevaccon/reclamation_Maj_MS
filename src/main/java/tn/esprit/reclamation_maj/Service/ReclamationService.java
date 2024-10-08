package tn.esprit.reclamation_maj.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.esprit.reclamation_maj.Entitiy.Reclamation;
import tn.esprit.reclamation_maj.Repository.ReclamationRepository;

import java.util.List;

@Service
public class ReclamationService {

    @Autowired
    private ReclamationRepository reclamationRepository;

    public Reclamation createReclamation(Long loggedInUserId, String newPhone, String description,
                                         Reclamation.AchatStatus achatStatus, List<Long> produitIds) {
        Reclamation reclamation = new Reclamation();
        reclamation.setUserId(loggedInUserId);
        reclamation.setPhone(newPhone);
        reclamation.setDescription(description);
        reclamation.setAchatStatus(achatStatus);
        reclamation.setProduitIds(produitIds);
        // Set other fields as needed
        return reclamationRepository.save(reclamation);
    }

    public List<Reclamation> getMyReclamations(Long loggedInUserId) {
        // Implement logic to fetch reclamations by user ID
        return reclamationRepository.findAll(); // Example placeholder
    }

    public Page<Reclamation> getAllReclamations(int page, int size, Reclamation.Status status,
                                                Long handledBy, Long userId, Long produitId) {
        Pageable pageable = PageRequest.of(page, size);
        if (status != null || handledBy != null || userId != null || produitId != null) {
            return reclamationRepository.findByStatusAndHandledByAndUserIdAndProduitIdsContaining(
                    status, handledBy, userId, produitId, pageable);
        } else {
            return reclamationRepository.findAll(pageable);
        }
    }

    // Implement other methods as per your requirements
}
