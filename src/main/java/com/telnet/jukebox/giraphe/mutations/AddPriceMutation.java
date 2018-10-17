package com.telnet.jukebox.giraphe.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creactiviti.giraphe.graph.Graph;
import com.creactiviti.giraphe.graph.Node;
import com.creactiviti.giraphe.graph.SimpleNode;
import com.creactiviti.giraphe.graphql.Arguments;
import com.creactiviti.giraphe.graphql.Fields;
import com.creactiviti.giraphe.graphql.MutationBuilder;
import com.telnet.jukebox.giraphe.entities.Price;

import graphql.schema.GraphQLObjectType.Builder;

@Component
public class AddPriceMutation implements MutationBuilder {

	@Autowired
	private Graph g;

	@Override
	public void build(Builder aBuilder) {
		aBuilder.field(Fields.field("addPrice").type(Price.REF).argument(Arguments.notNullStringArgument("price"))
				.dataFetcher((env) -> {
					Node node = SimpleNode.builder(g).type(Price.NAME).properties(env.getArguments()).build();
					return g.add(node);
				}));
	}
}
