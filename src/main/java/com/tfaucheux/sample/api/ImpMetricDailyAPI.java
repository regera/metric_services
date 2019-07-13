package com.tfaucheux.sample.api;

import com.tfaucheux.sample.model.ImpMetricDaily;
import com.tfaucheux.sample.model.ImpMetricDailyDAO;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Sample ImpMetricDaily REST API
 */
@Path("/MetricsDaily")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ImpMetricDailyAPI {

	@Inject
	ImpMetricDailyDAO dao;

	@Inject
	Logger log;

	@GET
	public List<ImpMetricDaily> list() {
		log.debug("listing all impMetricDailys");
		return dao.getAll();
	}

	@GET
	@Path("/search/{str}")
	public List<ImpMetricDaily> list(@PathParam("str") String str) {
		log.debug("search impMetricDailys for string: "+ str + "%");
		return dao.getByString(str);
	}

	@GET
	@Path("/since/{id}")
	public List<ImpMetricDaily> list(@PathParam("id") Long id) {
		log.debug("search impMetricDailys since: "+ id);
		return dao.getSince(id);
	}

	@GET
	@Path("/between/{id1}/{id2}")
	public List<ImpMetricDaily> list(@PathParam("id1") Date id1, @PathParam("id2") Date id2) {
		log.debug("search impMetricDailys between: "+ id1 + " and " + id2);
		return dao.getBetween(id1, id2);
	}

/*
        @GET
        @Path("/max")
        public ImpMetricDaily get() {
                log.debug("search impDailyMetric max: ");
                return dao.getMax();
        }
*/

	@GET
	@Path("/max")
        public BigDecimal get() {
           log.debug("search impDailyMetric max: ");
           return dao.getNativeMax();
    }

	@GET
	@Path("/{id}")
	public ImpMetricDaily get(@PathParam("id") String id) {
		log.debug("search impMetricDailys for Id: " + id);
		if (Utils.isNumber(id)) {
			return dao.getOne(Long.valueOf(id));
		} else {
			return dao.getOne(id);
		}
	}

	@POST
	public ImpMetricDaily save(ImpMetricDaily impMetricDaily) {
		if (impMetricDaily != null && impMetricDaily.getId() != null) {
			log.debug("updating impMetricDaily for Id: " + impMetricDaily.getId());
			return dao.update(impMetricDaily);
		} else {
			log.debug("inserting impMetricDaily for Id: " + impMetricDaily.getId());
			return dao.insert(impMetricDaily);
		}
	}

	@PUT
	public ImpMetricDaily update(ImpMetricDaily impMetricDaily) {
		log.debug("updating impMetricDaily for id: " + impMetricDaily.getId());
		return dao.update(impMetricDaily);
	}

	@DELETE
	@Path("/{id}")
	public void remove(@PathParam("id") Long id) {
		log.debug("removing impMetricDaily for id: " + id);
		dao.remove(id);
	}

}
