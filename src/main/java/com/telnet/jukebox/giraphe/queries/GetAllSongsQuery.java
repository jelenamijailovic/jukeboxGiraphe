package com.telnet.jukebox.giraphe.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creactiviti.giraphe.graph.Graph;
import com.creactiviti.giraphe.graphql.Fields;
import com.creactiviti.giraphe.graphql.QueryBuilder;
import com.creactiviti.giraphe.graphql.Types;
import com.telnet.jukebox.giraphe.entities.Song;

import graphql.schema.GraphQLObjectType.Builder;

@Component
public class GetAllSongsQuery implements QueryBuilder {

	@Autowired private Graph g;
	  
	  @Override
	  public void build(Builder aBuilder) {
	    aBuilder.field(Fields.field("getAllSongs")
	                         .type(Types.list(Song.REF))
	                         .dataFetcher((env) -> {
	                           return g.nodes()
	                                   .type(Song.NAME);
	                         }));
	  }
}
