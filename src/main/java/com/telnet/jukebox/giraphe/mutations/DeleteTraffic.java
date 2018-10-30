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
import com.telnet.jukebox.giraphe.entities.Traffic;

import graphql.schema.GraphQLObjectType.Builder;

@Component
public class DeleteTraffic implements MutationBuilder {

	@Autowired
	private Graph g;

	private final JdbcTemplate jdbc;

	public DeleteTraffic(DataSource aDatasource) {
		jdbc = new JdbcTemplate(aDatasource);
	}

	String sql = "delete from node where id=?";

	@Override
	public void build(Builder aBuilder) {
		aBuilder.field(Fields.field("deleteTraffic").type(Types.list(Traffic.REF))
				.argument(Arguments.stringArgument("id")).dataFetcher((env) -> {
					jdbc.update(sql, (Object) env.getArgument("id"));
					return g.nodes().type(Traffic.NAME);
				}));
	}

}
