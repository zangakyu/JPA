package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Spectacle;

public class SpectacleDao {
	private EntityManager em;
	
	public SpectacleDao(EntityManager em) {
		this.em=em;
	}
        
        /**
	 * rend persistant un nouveau spectacle
	 * @param s
	 */
	public void persist(Spectacle s){
            em.persist(s);
	}
	
	/**
	 * retourne tous les spectacles, triés par titre
	 */
	public List<Spectacle> findAll(){
		
		String jpql = "SELECT s FROM Spectacle AS s ORDER BY s.titre";
		TypedQuery<Spectacle> query = em.createQuery(jpql, Spectacle.class);
		
		return query.getResultList();
		
	}
	
	/**
	 * retourne le spectacle identifié par l’ID donné
	 * @param id
	 */
	public Spectacle findById(Long id){			
		return em.find(Spectacle.class, id);
	}

	/**
	 * retourne les spectacles dont l’artiste contient la chaine donnée, en ignorant la casse
	 * @param chaine
	 */
	public Spectacle findByArtiste(String chaine){
		String jpql = "SELECT s FROM Spectacle AS s WHERE s.artiste = :artiste";	
		TypedQuery<Spectacle> query = em.createQuery(jpql, Spectacle.class);
		query.setParameter("artiste", chaine);
		return query.getSingleResult();
	}
        
        
        /**
         * Retourner les lignes qui contiennent un nom en paramètre
         * |=====|
         * | SQL |
         * |=====|
         * SELECT * from CMD c 
         * LEFT JOIN LIGNE l ON c.id = l.cmd_id
         * WHERE c.name = ?
         * 
         * |======|
         * | JPQL |
         * |======|
         * SELECT distinct c from Command.c
         * LEFT JOIN FETCH c.lignes
         * WHERE c.name = :name
         */
	
	
}
