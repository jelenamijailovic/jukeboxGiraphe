package com.telnet.jukebox.giraphe.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creactiviti.giraphe.graph.Graph;
import com.creactiviti.giraphe.graph.Node;
import com.creactiviti.giraphe.graph.SimpleNode;
import com.creactiviti.giraphe.graphql.Arguments;
import com.creactiviti.giraphe.graphql.Fields;
import com.creactiviti.giraphe.graphql.MutationBuilder;
import com.telnet.jukebox.giraphe.entities.Song;

import graphql.schema.GraphQLObjectType.Builder;

@Component
public class AddSongMutation implements MutationBuilder {

	@Autowired
	private Graph g;

	@Override
	public void build(Builder aBuilder) {
		aBuilder.field(Fields.field("addSong").type(Song.REF).argument(Arguments.notNullStringArgument("name"))
				.dataFetcher((env) -> {
					Node node = SimpleNode.builder(g).type(Song.NAME).properties(env.getArguments()).build();
					return g.add(node);
				}));
	}
}
