package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Carte")
public class PaiementParCarte extends AbstractPaiement {
    
}
