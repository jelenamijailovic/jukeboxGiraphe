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

/**
 * @author Arik Cohen
 * @since Dec 16, 2017
 */
@Component
public class AddTrafficUserMutation implements MutationBuilder {

	@Autowired
	private Graph g;

	@Override
	public void build(Builder aBuilder) {

		aBuilder.field(Fields.field("addTrafficUser").type(Scalars.GraphQLString)
				.argument(Arguments.notNullStringArgument("traffictId"))
				.argument(Arguments.notNullStringArgument("userId")).dataFetcher((env) -> {
					Edge edge = SimpleEdge.builder(g).type("executes").fromNodeId(env.getArgument("userId"))
							.toNodeId(env.getArgument("traffictId")).build();
					g.add(edge);

					return "OK";
				}));
	}

}