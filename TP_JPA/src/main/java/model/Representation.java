package model;

//import java.util.Set;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Representation {
    
    @Id
    @SequenceGenerator(name = "rep_seq", sequenceName = "representation_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rep_seq")
    private long id;
    
    private Date date;
    
    @ManyToOne
    @JoinColumn(name = "ID_SPECTACLE")
    private Spectacle spectacle;
    
    //@OneToMany(mappedBy = "representation")
    //Set<Ticket> tickets;
    
}
