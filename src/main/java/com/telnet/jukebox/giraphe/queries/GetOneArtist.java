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
				.argument(Arguments.stringArgument("name")).dataFetcher((env) -> {
					//System.out.println("PROBA PROBA " + env.getArguments());
					// System.out.println(g.nodes().type(Artist.NAME).has("name",
					// env.getArgument("name")));
					// System.out.println(JSON.write(env.getArguments()));
					// System.out.println("gfagfdsgfs: "+env.getArgument("name"));
					System.out.println(g.nodes().type(Artist.NAME).has("name", env.getArgument("name")).iterator().next()
							.property("name").toString());
					return g.nodes().type(Artist.NAME).has("name", env.getArgument("name"));
				}));
	}

}
