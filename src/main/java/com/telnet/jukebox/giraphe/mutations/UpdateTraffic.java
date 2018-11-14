package com.telnet.jukebox.giraphe.mutations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.creactiviti.giraphe.graph.Graph;
import com.creactiviti.giraphe.graphql.Arguments;
import com.creactiviti.giraphe.graphql.Fields;
import com.creactiviti.giraphe.graphql.MutationBuilder;
import com.creactiviti.giraphe.graphql.Types;
import com.creactiviti.giraphe.utils.JSON;
import com.telnet.jukebox.giraphe.entities.Traffic;

import graphql.schema.GraphQLObjectType.Builder;

@Component
public class UpdateTraffic implements MutationBuilder {

	@Autowired
	private Graph g;

	private final JdbcTemplate jdbc;

	public UpdateTraffic(DataSource aDatasource) {
		jdbc = new JdbcTemplate(aDatasource);
	}

	String sql = "update node set properties=?::jsonb where id=?";

	@Override
	public void build(Builder aBuilder) {
		aBuilder.field(
				Fields.field("updateTraffic").type(Types.list(Traffic.REF)).argument(Arguments.stringArgument("id"))
						.argument(Arguments.stringArgument("user")).dataFetcher((env) -> {

							jdbc.update(sql, JSON.write(env.getArguments()), (Object) env.getArgument("id"));

							return g.nodes().type(Traffic.NAME);
						}));
	}

}
