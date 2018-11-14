package com.telnet.jukebox.giraphe.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creactiviti.giraphe.graph.Graph;
import com.creactiviti.giraphe.graphql.Fields;
import com.creactiviti.giraphe.graphql.QueryBuilder;
import com.creactiviti.giraphe.graphql.Types;
import com.telnet.jukebox.giraphe.entities.Artist;

import graphql.schema.GraphQLObjectType.Builder;

/**
 * @author Arik Cohen
 * @since Dec 16, 2017
 */
@Component
public class GetAllArtistsQuery implements QueryBuilder {

	@Autowired
	private Graph g;

	@Override
	public void build(Builder aBuilder) {
		aBuilder.field(Fields.field("getAllArtists").type(Types.list(Artist.REF)).dataFetcher((env) -> {
			return g.nodes().type(Artist.NAME);
		}));
	}

}
