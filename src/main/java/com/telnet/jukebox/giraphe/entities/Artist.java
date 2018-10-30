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
public class Artist implements TypeBuilder {

	public static final String NAME = "Artist";
	public static final GraphQLTypeReference REF = Types.ref(NAME);

	@Override
	public GraphQLType build() {
		return Types.elementTypeBuilder().name(NAME).field(Fields.stringField("name"))
				.field(Fields.spelField("songs", "${source.from('sings')}") // SPEL Expression
						.type(Types.list(Song.REF)))
				.field(Fields.spelField("genre", "${source.from('contains')}") // SPEL Expression
						.type(Types.list(Genre.REF)))
				.build();
	}

}
