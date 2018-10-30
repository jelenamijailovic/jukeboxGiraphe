package com.telnet.jukebox.giraphe.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creactiviti.giraphe.graph.Graph;
import com.creactiviti.giraphe.graphql.Arguments;
import com.creactiviti.giraphe.graphql.Fields;
import com.creactiviti.giraphe.graphql.MutationBuilder;
import com.creactiviti.giraphe.graphql.Types;
import com.telnet.jukebox.giraphe.entities.Artist;

import graphql.schema.GraphQLObjectType.Builder;

/**
 * @author Arik Cohen
 * @since Dec 16, 2017
 */
@Component
public class GetOneArtist implements MutationBuilder {

	@Autowired
	private Graph g;

	@Override
	public void build(Builder aBuilder) {
		aBuilder.field(Fields.field("getOneArtist").type(Types.list(Artist.REF))
				.argument(Arguments.stringArgument("id")).dataFetcher((env) -> {
					return g.nodes().type(Artist.NAME).hasId(env.getArgument("id"));
				}));
	}

}
