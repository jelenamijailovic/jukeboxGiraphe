package com.telnet.jukebox.giraphe.mutations;

import java.util.Date;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.creactiviti.giraphe.graph.Graph;
import com.creactiviti.giraphe.graph.Node;
import com.creactiviti.giraphe.graph.Traversal;
import com.creactiviti.giraphe.graphql.Arguments;
import com.creactiviti.giraphe.graphql.Fields;
import com.creactiviti.giraphe.graphql.MutationBuilder;
import com.creactiviti.giraphe.graphql.Types;
import com.telnet.jukebox.giraphe.entities.User;

import graphql.schema.GraphQLObjectType.Builder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Arik Cohen
 * @since Dec 16, 2017
 */
@Component
public class LoginUserMutations implements MutationBuilder {

	@Autowired
	private Graph g;

	@Autowired
	HttpServletResponse responseServlet;

	RestTemplate restTemplate = new RestTemplate();

	@Override
	public void build(Builder aBuilder) {
		aBuilder.field(Fields.field("loginUser").type(Types.list(User.REF)).argument(Arguments.stringArgument("email"))
				.argument(Arguments.stringArgument("password")).dataFetcher((env) -> {
					Traversal<Node> userByEmail = g.nodes().type(User.NAME).has("email", env.getArgument("email"));

					Traversal<Node> userByPassword = g.nodes().type(User.NAME).has("password",
							env.getArgument("password"));
					
					String jwt = "";
					String email;
					
					try {
						userByEmail.next();
						try {
							email = userByPassword.iterator().next().property("email").toString();
							System.out.println(email);
							if (!email.equals(null)) {
								Long time = System.currentTimeMillis();
								String id = g.nodes().type(User.NAME).has("password", env.getArgument("password")).next().id();
								System.out.println("id je: " + id);
								jwt = Jwts.builder().claim("email", email).claim("id", id)
										.setExpiration(new Date(time + 600000000))
										.signWith(SignatureAlgorithm.HS256, "sifra".getBytes()).compact() + "jelena";

							}
							System.out.println("Login succeed!");
							responseServlet.setHeader("Authorization", jwt);
							return userByPassword;
						} catch (NoSuchElementException e) {
							System.out.println("Wrong password!");
							e.printStackTrace();
						}
					} catch (NoSuchElementException e) {
						System.out.println("There is no user with this email!");
						e.printStackTrace();
					}
					
					responseServlet.setHeader("Authorization", jwt);
					System.out.println(jwt);
					return g.nodes().type(User.NAME).has("email", env.getArgument("email")).has("password", env.getArgument("password"));
				}));
	}

}