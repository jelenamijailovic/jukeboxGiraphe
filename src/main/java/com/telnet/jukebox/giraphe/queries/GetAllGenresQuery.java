package com.telnet.jukebox.giraphe.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creactiviti.giraphe.graph.Graph;
import com.creactiviti.giraphe.graphql.Fields;
import com.creactiviti.giraphe.graphql.QueryBuilder;
import com.creactiviti.giraphe.graphql.Types;
import com.telnet.jukebox.giraphe.entities.Genre;

import graphql.schema.GraphQLObjectType.Builder;

@Component
public class GetAllGenresQuery implements QueryBuilder {

	@Autowired private Graph g;
	  
	  @Override
	  public void build(Builder aBuilder) {
	    aBuilder.field(Fields.field("getAllGenres")
	                         .type(Types.list(Genre.REF))
	                         .dataFetcher((env) -> {
	                           return g.nodes()
	                                   .type(Genre.NAME);
	                         }));
	  }
}
