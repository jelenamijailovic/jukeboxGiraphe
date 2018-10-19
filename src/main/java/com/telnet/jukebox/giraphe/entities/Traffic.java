package com.telnet.jukebox.giraphe.entities;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.creactiviti.giraphe.graphql.Fields;
import com.creactiviti.giraphe.graphql.TypeBuilder;
import com.creactiviti.giraphe.graphql.Types;
//import com.zhokhov.graphql.datetime.GraphQLDate;

import graphql.Scalars;
import graphql.language.Argument;
import graphql.schema.GraphQLScalarType;
import graphql.schema.GraphQLType;
import graphql.schema.GraphQLTypeReference;

@Component
public class Traffic implements TypeBuilder {

	public final Date sqlDate = new java.sql.Date(System.currentTimeMillis());
	public static final String NAME = "Traffic";
	  public static final GraphQLTypeReference REF = Types.ref(NAME);

	  @Override
	  public GraphQLType build() {
	    return Types.elementTypeBuilder()
	                .name(NAME)
	                .field(Fields.stringField("date"))
	                .field(Fields.stringField("user"))
	                .field(Fields.spelField("songs", "${source.from('placed')}") // SPEL Expression
	                             .type(Types.list(Song.REF)))
	                .build();
	  }
}
