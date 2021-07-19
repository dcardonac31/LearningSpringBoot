package com.contacto.inicio;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	//definición roles y usuarios
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
        .inMemoryAuthentication()
        .withUser("user1")
          .password("{noop}user1") //lo de {noop} se pone para no obligar a usar mecanismo de encriptación
          .roles("USER")
          .and()
        .withUser("admin")
          .password("{noop}admin")
          .roles("USER", "ADMIN");
		
		/*Lo siguiente sería para el caso de que
		 * quisieramos encriptar el password:
		  auth
		 	.inMemoryAuthentication()
		 	.withUser("user1")
		 		.password(new BCryptPasswordEncoder().encode("user1"))
		 		.roles("USER")
		 		.and()
			.withUser("admin")
				.password(new BCryptPasswordEncoder().encode("admin"))
				.roles("USER", "ADMIN")
		 */
		
		/*La siguiente configuración será para el caso de
		 * usuarios en una base de datos
		 	auth.jdbcAuthentication().dataSource(dataSource)
		 		.usersByUsernameQuery("select username, authority "
		 			+ "from authorities where username=?");
		 */
	}
	//definición  de políticas de seguridad
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		//solo los miembros del rol admin podrán realizar altas
		//y para ver la lista de contactos, tendrán que estar autenticados
		.antMatchers(HttpMethod.POST,"/contactos").hasRole("ADMIN")
		.antMatchers("/**").authenticated()
		//.antMatchers("/contactos").authenticated()	
		//.antMatchers("/contactos/**").authenticated()
		.and()
		.httpBasic();
	}
}
