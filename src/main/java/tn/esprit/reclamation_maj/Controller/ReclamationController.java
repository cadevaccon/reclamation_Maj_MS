package tn.esprit.reclamation_maj.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import tn.esprit.reclamation_maj.Entitiy.Reclamation;
import tn.esprit.reclamation_maj.Service.ReclamationService;

import java.util.List;

@RestController
@RequestMapping("/reclamations")
 public class ReclamationController {

    @Autowired
    private ReclamationService reclamationService;

    @PostMapping("/create")
    public Reclamation createReclamation(@RequestParam Long loggedInUserId,
                                         @RequestParam(required = false) String newPhone,
                                         @RequestParam String description,
                                         @RequestParam Reclamation.AchatStatus achatStatus,
                                         @RequestParam List<Long> produitIds) {
        return reclamationService.createReclamation(loggedInUserId, newPhone, description, achatStatus, produitIds);
    }

    @GetMapping("/my")
    public List<Reclamation> getMyReclamations(@RequestParam Long loggedInUserId) {
        return reclamationService.getMyReclamations(loggedInUserId);
    }

    @GetMapping("/all")
    public Page<Reclamation> getAllReclamations(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Reclamation.Status status,
            @RequestParam(required = false) Long handledBy,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long produitId) {

        return reclamationService.getAllReclamations(page, size, status, handledBy, userId, produitId);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    // Implement other endpoints as per your requirements
}
