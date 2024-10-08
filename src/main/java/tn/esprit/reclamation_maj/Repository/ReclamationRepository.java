package tn.esprit.reclamation_maj.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.reclamation_maj.Entitiy.Reclamation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
    // Custom query methods can be added here if needed

    Page<Reclamation> findAll(Pageable pageable);

    // Custom method to filter by status, handledBy, userId, etc.
    Page<Reclamation> findByStatusAndHandledByAndUserIdAndProduitIdsContaining(
            Reclamation.Status status, Long handledBy, Long userId, Long produitId, Pageable pageable);

}