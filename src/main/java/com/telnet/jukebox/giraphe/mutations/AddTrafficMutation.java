package com.telnet.jukebox.giraphe.mutations;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creactiviti.giraphe.graph.Graph;
import com.creactiviti.giraphe.graph.Node;
import com.creactiviti.giraphe.graph.SimpleNode;
import com.creactiviti.giraphe.graphql.Arguments;
import com.creactiviti.giraphe.graphql.Fields;
import com.creactiviti.giraphe.graphql.MutationBuilder;
import com.telnet.jukebox.giraphe.entities.Traffic;

import graphql.schema.GraphQLObjectType.Builder;

@Component
public class AddTrafficMutation implements MutationBuilder {

	@Autowired
	private Graph g;

	public final Date sqlDate = new java.sql.Date(System.currentTimeMillis());

	@Override
	public void build(Builder aBuilder) {
		aBuilder.field(Fields.field("addTraffic").type(Traffic.REF)
				 // .argument(Arguments.notNullStringArgument("songs"))
				.argument(Arguments.notNullStringArgument("user")).dataFetcher((env) -> {
					Node node = SimpleNode.builder(g).type(Traffic.NAME).property("id", env.getArgument("id"))
							.property("date", sqlDate.toString()).property("song", env.getArgument("song")).property("user", env.getArgument("user")).build();
					return g.add(node);
				}));
	}

}
