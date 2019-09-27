/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supercars.rest;

import com.supercars.Quote;
import com.supercars.externaldata.InsuranceQuotes;
import com.supercars.tracing.TracingHelper;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tombatchelor
 */
@Path("/insurance")
public class InsuranceService {
    
    @Path("quote/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Quote getQuote(@PathParam("id") int id) {
        Quote quote = InsuranceQuotes.getQuote(id);
        
        TracingHelper.tag(TracingHelper.CARS_APP_NAME, "supercars.insurance.Company", quote.getCompany());
        TracingHelper.tag(TracingHelper.CARS_APP_NAME, "supercars.insurance.Price", (long) quote.getPrice());
        
        return quote;
    }
}