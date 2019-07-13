package com.tfaucheux.sample.api;

import com.tfaucheux.sample.model.AudienceInsight;
import com.tfaucheux.sample.model.AudienceInsightDAO;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Sample AudienceInsight REST API
 */
@Path("/AudienceInsights")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AudienceInsightAPI {

	@Inject
	AudienceInsightDAO dao;

	@Inject
	Logger log;

	@GET
	public List<AudienceInsight> list() {
		log.debug("listing all AudienceInsights");
		return dao.getAll();
	}

	@GET
	@Path("/search/{transactionId}/{key}")
	public List<AudienceInsight> list(@PathParam("transactionId") Long transactionId, @PathParam("key") String key) {
		log.debug("search AudienceInsights for transactionId:" + transactionId + ",key: "+ key);
		return dao.getByKey(transactionId,key);
	}

	@GET
	@Path("/search/{transactionId}")
	public List<AudienceInsight> list(@PathParam("transactionId") Long transactionId) {
		log.debug("search AudienceInsights for transactionId:" + transactionId);
		return dao.getByTransactionId(transactionId);
	}

	@GET
	@Path("/{id}")
	public AudienceInsight get(@PathParam("id") String id) {
		log.debug("search audienceInsights for id: " + id);
		if (Utils.isNumber(id)) {
			return dao.getOne(Long.valueOf(id));
		} else {
			return dao.getOne(id);
		}
	}

	@POST
	public AudienceInsight save(AudienceInsight audienceInsight) {
		if (audienceInsight != null && audienceInsight.getId() != null) {
			log.debug("updating audienceInsight for Id: " + audienceInsight.getId());
			return dao.update(audienceInsight);
		} else {
			log.debug("inserting audienceInsight for Id: " + audienceInsight.getId());
			return dao.insert(audienceInsight);
		}
	}

	@PUT
	public AudienceInsight update(AudienceInsight audienceInsight) {
		log.debug("updating audienceInsight for id: " + audienceInsight.getId());
		return dao.update(audienceInsight);
	}

	@DELETE
	@Path("/{id}")
	public void remove(@PathParam("id") Long id) {
		log.debug("removing audienceInsight for id: " + id);
		dao.remove(id);
	}

}
