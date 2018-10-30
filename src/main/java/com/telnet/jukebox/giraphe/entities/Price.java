package com.telnet.jukebox.giraphe.entities;

import org.springframework.stereotype.Component;

import com.creactiviti.giraphe.graphql.Fields;
import com.creactiviti.giraphe.graphql.TypeBuilder;
import com.creactiviti.giraphe.graphql.Types;

import graphql.schema.GraphQLType;
import graphql.schema.GraphQLTypeReference;

@Component
public class Price implements TypeBuilder {

	public static final String NAME = "Price";
	public static final GraphQLTypeReference REF = Types.ref(NAME);

	@Override
	public GraphQLType build() {
		return Types.elementTypeBuilder().name(NAME).field(Fields.stringField("price")).build();
	}

}
