package com.telnet.jukebox.giraphe.entities;

import org.springframework.stereotype.Component;

import com.creactiviti.giraphe.graphql.Fields;
import com.creactiviti.giraphe.graphql.TypeBuilder;
import com.creactiviti.giraphe.graphql.Types;

import graphql.schema.GraphQLType;
import graphql.schema.GraphQLTypeReference;

/**
 * @author Arik Cohen
 * @since Dec 16, 2017
 */
@Component
public class User implements TypeBuilder {

	public static final String NAME = "User";
	public static final GraphQLTypeReference REF = Types.ref(NAME);

	@Override
	public GraphQLType build() {
		return Types.elementTypeBuilder().name(NAME).field(Fields.stringField("email"))
				.field(Fields.stringField("password")).field(Fields.spelField("traffic", "${source.from('executes')}") // SPEL
																														// Expression
						.type(Types.list(Traffic.REF)))
				.build();
	}

}