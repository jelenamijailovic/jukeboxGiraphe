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
public class AddTrafficSongMutation implements MutationBuilder {

	@Autowired
	private Graph g;

	@Override
	public void build(Builder aBuilder) {
		aBuilder.field(Fields.field("addTrafficSong").type(Scalars.GraphQLString)
				.argument(Arguments.notNullStringArgument("trafficId"))
				.argument(Arguments.notNullStringArgument("songId")).dataFetcher((env) -> {
					Edge edge = SimpleEdge.builder(g).type("placed").fromNodeId(env.getArgument("songId"))
							.toNodeId(env.getArgument("trafficId")).build();
					g.add(edge);

					return "OK";
				}));
	}
}
