package tn.esprit.reclamation_maj.Entitiy;


import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reclamation")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "handled_by")
    private Long handledBy;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "handled_at")
    private Date handledAt;

    @Column(name = "admin_note")
    private String adminNote;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "achatStatus")
    private AchatStatus achatStatus;

    @Column(name = "achatId")
    private Long achatId;

    @ElementCollection
    @CollectionTable(name = "reclamation_produits", joinColumns = @JoinColumn(name = "id_reclamation"))
    @Column(name = "produit_id")
    private List<Long> produitIds;

    @Column(name = "phone")
    private String phone;

    // Constructors, getters, setters, and other methods

    public Reclamation() {
        // Default constructor
    }

    // Enum for Status
    public enum Status {
        NEW,
        HANDLING,
        WAITING_RESPONSE,
        CLOSED,
        OPEN,
        COMPLETED
    }

    // Enum for AchatStatus
    public enum AchatStatus {
        DONE,
        RECLAIMED,
        ECHANGE,
        MODIFIED,
        RETURNED
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getHandledBy() {
        return handledBy;
    }

    public void setHandledBy(Long handledBy) {
        this.handledBy = handledBy;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getHandledAt() {
        return handledAt;
    }

    public void setHandledAt(Date handledAt) {
        this.handledAt = handledAt;
    }

    public String getAdminNote() {
        return adminNote;
    }

    public void setAdminNote(String adminNote) {
        this.adminNote = adminNote;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AchatStatus getAchatStatus() {
        return achatStatus;
    }

    public void setAchatStatus(AchatStatus achatStatus) {
        this.achatStatus = achatStatus;
    }

    public List<Long> getProduitIds() {
        return produitIds;
    }

    public void setProduitIds(List<Long> produitIds) {
        this.produitIds = produitIds;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
