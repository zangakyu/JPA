package model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Ticket {
    
    @Id
    @SequenceGenerator(name = "ticket_seq", sequenceName = "ticket_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "ID_REPRESENTATION")
    private Representation representation;
    
    @ManyToMany
    @JoinTable(name = "PAIEMENT_TICKET",
           joinColumns = @JoinColumn(name = "ID_TICKET"),
           inverseJoinColumns = @JoinColumn(name = "ID_PAIEMENT"))
    private Set<AbstractPaiement> paiements;
    
}
