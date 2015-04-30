package model;


import java.util.Set;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_PAIEMENT")
public abstract class AbstractPaiement {
    
    @Id
    @SequenceGenerator(name="pay_seq", sequenceName = "paiement_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pay_seq")
    private long id;
    
    @ManyToMany(mappedBy = "paiements")
    private Set<Ticket> tickets;
}
