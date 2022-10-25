package com.digitalbooks.authorservice.config;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.digitalbooks.authorservice.filter.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	/*
//	@Autowired
//	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	private UserDetailsService jwtUserDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(jwtUserDetailsService);
//		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors();
		// We don't need CSRF for this example
		httpSecurity.csrf().disable()
				// dont authenticate this particular request
				.authorizeRequests().antMatchers("/api/v1/digitalbooks/author/authenticate","/api/v1/digitalbooks/author/getAuthor/{authorId}","/api/v1/digitalbooks/books/*","/api/v1/digitalbooks/author/signup","/api/v1/digitalbooks/author/login").permitAll()
				// all other requests need to be authenticated
				.anyRequest().authenticated().and()

//			.formLogin()
//                .loginPage("/api/v1/digitalbooks/author/login")
//                .permitAll()
//                .and()
            
				// make sure we use stateless session; session won't be
				// used to store user's state.
				.exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		return httpSecurity.build();
	}
	
*/
	
	import java.util.Arrays;
	import java.util.Collections;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Properties;


	//import org.apache.kafka.clients.producer.ProducerConfig;
	//import org.apache.kafka.common.serialization.StringSerializer;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.http.HttpMethod;
	
	//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
	//import org.springframework.kafka.core.KafkaTemplate;
	//import org.springframework.kafka.core.ProducerFactory;
	//import org.springframework.kafka.support.serializer.JsonSerializer;
	import org.springframework.security.authentication.AuthenticationManager;
	import org.springframework.security.config.BeanIds;
	import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
	import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
	import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
	import org.springframework.security.config.http.SessionCreationPolicy;
	import org.springframework.security.config.web.server.ServerHttpSecurity;
	import org.springframework.security.core.userdetails.UserDetailsService;
	import org.springframework.security.crypto.password.NoOpPasswordEncoder;
	import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
	import org.springframework.security.web.server.SecurityWebFilterChain;
	import org.springframework.security.web.server.authentication.logout.DelegatingServerLogoutHandler;
	import org.springframework.security.web.server.authentication.logout.SecurityContextServerLogoutHandler;
	import org.springframework.security.web.server.authentication.logout.WebSessionServerLogoutHandler;
	import org.springframework.web.cors.CorsConfiguration;
	import org.springframework.web.cors.reactive.CorsWebFilter;
	import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import com.digitalbooks.authorservice.filter.JwtRequestFilter;



	



	@Configuration
	@EnableWebSecurity
	@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
	public class SecurityConfig extends WebSecurityConfigurerAdapter {



	   @Autowired
	    private UserDetailsService userDetailsService;



	   @Autowired
	    private JwtRequestFilter jwtFilter;
	    @Bean
	    public  CorsWebFilter corsWebFilter() {
	        CorsConfiguration corsConfig = new CorsConfiguration();
	        corsConfig.setAllowedOrigins(Collections.singletonList("*"));
	        corsConfig.setMaxAge(3600L);
	        corsConfig.setAllowedMethods(Arrays.asList("*"));
	        corsConfig.addAllowedHeader("*");



	       UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", corsConfig);



	       return new CorsWebFilter(source);
	    }
	    



	   
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService);
	    }
	    @Bean
	    public PasswordEncoder passwordEncoder(){
	        return NoOpPasswordEncoder.getInstance();
	    }



	   @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }



	   @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.cors().disable();
	        http.csrf().disable().authorizeRequests().antMatchers("/api/v1/digitalbooks/author/getAuthor/{authorId}","/api/v1/digitalbooks/books/","/api/v1/digitalbooks/author/signup","/api/v1/digitalbooks/author/login","api/v1/digitalbooks/books/createbook" ,"api/v1/digitalbooks/books/update")
	                .permitAll().antMatchers(HttpMethod.OPTIONS, "/**")
	                .permitAll()
	                .anyRequest()
	                .authenticated()
	                .and().exceptionHandling().and().sessionManagement()
	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	    }

	

}
