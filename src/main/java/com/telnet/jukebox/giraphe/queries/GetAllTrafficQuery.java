package com.telnet.jukebox.giraphe.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creactiviti.giraphe.graph.Graph;
import com.creactiviti.giraphe.graphql.Fields;
import com.creactiviti.giraphe.graphql.QueryBuilder;
import com.creactiviti.giraphe.graphql.Types;
import com.telnet.jukebox.giraphe.entities.Traffic;

import graphql.schema.GraphQLObjectType.Builder;

@Component
public class GetAllTrafficQuery implements QueryBuilder {

	@Autowired private Graph g;
	  
	  @Override
	  public void build(Builder aBuilder) {
	    aBuilder.field(Fields.field("getAllTraffic")
	                         .type(Types.list(Traffic.REF))
	                         .dataFetcher((env) -> {
	                           return g.nodes()
	                                   .type(Traffic.NAME);
	                         }));
	  }
}
