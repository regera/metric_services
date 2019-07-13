package com.tfaucheux.sample.model;

import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.math.BigDecimal;

/**
 *  Sample ImpMetricDailyDAO
 */
public class ImpMetricDailyDAO {

	@Inject
	EntityManager em;

	@Inject
	Logger log;

	public List<ImpMetricDaily> getAll() {
		return em.createQuery("select c from ImpMetricDaily c", ImpMetricDaily.class)
				  .setMaxResults(5000)
				  .getResultList();
	}

	public List<ImpMetricDaily> getByString(String str) {
		return em.createQuery("select c from ImpMetricDaily c where c.loginName like :str",
					  ImpMetricDaily.class)
				  .setParameter("str", str.toUpperCase().replace('*','%') + "%")
				  .setMaxResults(5000)
				  .getResultList();
	}

	public ImpMetricDaily getOne(Long id) {
		return em.find(ImpMetricDaily.class, id);
	}

	public ImpMetricDaily getOne(String id) {
		try {
			return em.createQuery("select c from ImpMetricDaily c where c.id = :id", ImpMetricDaily.class)
					  .setParameter("id", id)
					  .getSingleResult();
		} catch (NoResultException nre) {
			log.error(nre);
			return getNoResultObject();
		}
	}

        public ImpMetricDaily getMax() {
                try {
                        return em.createQuery("select c from ImpMetricDaily c where c.id = (select max(x.id) from ImpMetricDaily x)", ImpMetricDaily.class)
                                          .getSingleResult();
                } catch (NoResultException nre) {
                        log.error(nre);
                        return getNoResultObject();
                }
        }
        public BigDecimal getNativeMax() {
                try {
		 // return (BigDecimal)em.createStoredProcedureQuery("impower.imp_get_max_metric_id").execute();
		 StoredProcedureQuery p = em.createStoredProcedureQuery("impower.imp_get_max_metric_id");
                 p.registerStoredProcedureParameter(1, BigDecimal.class, ParameterMode.OUT);
                 p.execute();
                 BigDecimal max = (BigDecimal) p.getOutputParameterValue(1);
                 return max;
                } catch (NoResultException nre) {
                        log.error(nre);
                        return new BigDecimal(-1);
                }
        }

	public List<ImpMetricDaily> getSince(Long id) {
			return em.createQuery("select c from ImpMetricDaily c where trunc(c.createDate) = trunc(sysdate) and c.id > :id order by c.id", ImpMetricDaily.class)
					.setParameter("id", id)
					.setMaxResults(5000)
					.getResultList();
	}

	public List<ImpMetricDaily> getBetween(Date id1, Date id2) {
			return em.createQuery("select c from ImpMetricDaily c where trunc(c.createDate) between trunc(:id1) and trunc(:id2) order by c.id", ImpMetricDaily.class)
					.setParameter("id1", id1)
					.setParameter("id2", id2)
					// .setMaxResults(5000)
					.getResultList();
	}


	public ImpMetricDaily insert(ImpMetricDaily impMetricDaily) {
		try {
			em.getTransaction().begin();
			em.persist(impMetricDaily);
			em.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			em.getTransaction().rollback();
		}
		return impMetricDaily;
	}

	public ImpMetricDaily update(ImpMetricDaily impMetricDaily) {
		try {
			em.getTransaction().begin();
			em.merge(impMetricDaily);
			em.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			em.getTransaction().rollback();
		}
		return impMetricDaily;
	}

	public void remove(Long id) {
		ImpMetricDaily impMetricDaily = em.find(ImpMetricDaily.class, id);
		try {
			if (impMetricDaily != null) {
				em.getTransaction().begin();
				em.remove(impMetricDaily);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			log.error(e);
			em.getTransaction().rollback();
		}
	}

	public ImpMetricDaily getNoResultObject() {
		return null;
	}
}
