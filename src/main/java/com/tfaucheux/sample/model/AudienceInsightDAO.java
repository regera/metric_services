package com.tfaucheux.sample.model;

import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

/**
 *  Sample AudienceInsightDAO
 */
public class AudienceInsightDAO {

	@Inject
	EntityManager em;

	@Inject
	Logger log;

	public List<AudienceInsight> getAll() {
		return em.createQuery("select c from AudienceInsight c", AudienceInsight.class)
				  .setMaxResults(50)
				  .getResultList();
	}

	public List<AudienceInsight> getByTransactionId(Long transactionId) {
		return em.createQuery("select c from AudienceInsight c where c.transactionId = :transactionId", AudienceInsight.class)
				  .setParameter("transactionId", transactionId)
				  .setMaxResults(50)
				  .getResultList();
	}

	public List<AudienceInsight> getByKey(Long transactionId, String key) {
		return em.createQuery("select c from AudienceInsight c where c.transactionId = :transactionId and c.key = :key",
					  AudienceInsight.class)
				  .setParameter("transactionId", transactionId)
				  // .setParameter("key", key.toUpperCase().replace('*','%') + "%")
				  .setParameter("key", key)
				  .setMaxResults(50)
				  .getResultList();
	}

	public AudienceInsight getOne(Long id) {
		return em.find(AudienceInsight.class, id);
	}

	public AudienceInsight getOne(String id) {
		try {
			return em.createQuery("select c from AudienceInsight c where c.id = :id", AudienceInsight.class)
					  .setParameter("id", id)
					  .getSingleResult();
		} catch (NoResultException nre) {
			log.error(nre);
			return getNoResultObject();
		}
	}

	public AudienceInsight insert(AudienceInsight audienceInsight) {
		try {
			em.getTransaction().begin();
			em.persist(audienceInsight);
			em.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			em.getTransaction().rollback();
		}
		return audienceInsight;
	}

	public AudienceInsight update(AudienceInsight audienceInsight) {
		try {
			em.getTransaction().begin();
			em.merge(audienceInsight);
			em.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			em.getTransaction().rollback();
		}
		return audienceInsight;
	}

	public void remove(Long id) {
		AudienceInsight audienceInsight = em.find(AudienceInsight.class, id);
		try {
			if (audienceInsight != null) {
				em.getTransaction().begin();
				em.remove(audienceInsight);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			log.error(e);
			em.getTransaction().rollback();
		}
	}

	public AudienceInsight getNoResultObject() {
		return null;
	}
}
