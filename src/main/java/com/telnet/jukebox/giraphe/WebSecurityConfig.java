package com.telnet.jukebox.giraphe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.stereotype.Component;

import com.creactiviti.giraphe.graph.Graph;
import com.creactiviti.giraphe.graphql.MutationBuilder;
import com.telnet.jukebox.giraphe.mutations.LoginUserMutations;

import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLObjectType.Builder;

@Component
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//Builder mutationBuilder = GraphQLObjectType.newObject().name("MutationQuery");
	
	private LoginUserMutations login= new LoginUserMutations();

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/graphql")
				// .authenticated()
				.permitAll().and().requestCache().requestCache(new NullRequestCache()).and().headers()
				//.addHeaderWriter(new StaticHeadersWriter("Authorization", login.getJwt()))
				.frameOptions().sameOrigin() // needed
																														// for
																														// H2
																														// web
																														// console
				.and().sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true)
				.sessionRegistry(sessionRegistry());
	}

	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}
}