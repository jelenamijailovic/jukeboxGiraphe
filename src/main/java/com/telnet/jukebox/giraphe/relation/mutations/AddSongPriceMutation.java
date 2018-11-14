package com.telnet.jukebox.giraphe.relation.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creactiviti.giraphe.graph.Edge;
import com.creactiviti.giraphe.graph.Graph;
import com.creactiviti.giraphe.graph.SimpleEdge;
import com.creactiviti.giraphe.graphql.Arguments;
import com.creactiviti.giraphe.graphql.Fields;
import com.creactiviti.giraphe.graphql.MutationBuilder;

import graphql.Scalars;
import graphql.schema.GraphQLObjectType.Builder;

@Component
public class AddSongPriceMutation implements MutationBuilder {

	@Autowired
	private Graph g;

	@Override
	public void build(Builder aBuilder) {
		aBuilder.field(Fields.field("addSongPrice").type(Scalars.GraphQLString)
				.argument(Arguments.notNullStringArgument("songId"))
				.argument(Arguments.notNullStringArgument("priceId")).dataFetcher((env) -> {
					Edge edge = SimpleEdge.builder(g).type("relates").fromNodeId(env.getArgument("priceId"))
							.toNodeId(env.getArgument("songId")).build();
					g.add(edge);

					return "OK";
				}));
	}
}
