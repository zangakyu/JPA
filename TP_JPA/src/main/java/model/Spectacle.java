package model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity

public class Spectacle {
	@Id
        // name correspond au nom de la séquence utilisée
        // sequenceName est le nom de la séquence utilisé dans la BDD
        @SequenceGenerator(name = "seq", sequenceName = "spectacle_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Long id;

	@Enumerated(EnumType.STRING)
	private TypeDeSpectacle type;
        
        private String titre;
        private String artiste;
        
        @OneToMany(mappedBy = "spectacle")
        private Set<Representation> representations;

	protected Spectacle() {
	}

	public TypeDeSpectacle getType() {
		return type;
	}

	public void setType(TypeDeSpectacle type) {
		this.type = type;
	}

}
