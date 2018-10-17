package com.telnet.jukebox.giraphe.entities;

import org.springframework.stereotype.Component;

import com.creactiviti.giraphe.graphql.Fields;
import com.creactiviti.giraphe.graphql.TypeBuilder;
import com.creactiviti.giraphe.graphql.Types;

import graphql.schema.GraphQLType;
import graphql.schema.GraphQLTypeReference;

@Component
public class Song implements TypeBuilder {

	public static final String NAME = "Song";
	  public static final GraphQLTypeReference REF = Types.ref(NAME);

	  @Override
	  public GraphQLType build() {
	    return Types.elementTypeBuilder()
	                .name(NAME)
	                .field(Fields.stringField("name"))
	                .field(Fields.spelField("artists", "${source.from('sings')}") // SPEL Expression
	                             .type(Types.list(Artist.REF)))
	                .field(Fields.spelField("prices", "${source.from('relates')}") // SPEL Expression
                            .type(Types.list(Price.REF)))
	                .build();
	  }
}
