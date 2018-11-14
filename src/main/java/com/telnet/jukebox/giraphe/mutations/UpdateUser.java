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
import com.telnet.jukebox.giraphe.entities.User;

import graphql.schema.GraphQLObjectType.Builder;

@Component
public class UpdateUser implements MutationBuilder {

	@Autowired
	private Graph g;

	private final JdbcTemplate jdbc;

	public UpdateUser(DataSource aDatasource) {
		jdbc = new JdbcTemplate(aDatasource);
	}

	String sql = "update node set properties=('{\"email\":\"' || ? || '\", ' || '\"password\":\"' || ? || '\"}')::jsonb where id=?";

	@Override
	public void build(Builder aBuilder) {
		aBuilder.field(Fields.field("updateUser").type(Types.list(User.REF)).argument(Arguments.stringArgument("id"))
				.argument(Arguments.stringArgument("password")).dataFetcher((env) -> {

					jdbc.update(sql,
							(Object) g.nodes().type(User.NAME).hasId(env.getArgument("id")).next().property("email"),
							(Object) env.getArgument("password"), (Object) env.getArgument("id"));

					return g.nodes().type(User.NAME);
				}));
	}

}