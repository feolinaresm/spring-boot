package com.store.web.security;

import com.store.web.security.filter.JWTFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//Esta anotación nos permite reconocer esta clase como la encargada de manejar la seguridad del aplicativo
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTFilterRequest jwtFilterRequest;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService); //Al sobreescribir el metodo y pasar nuestro objeto de usuario, Spring dejará en nuestras manos el manejo de la seguridad
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Desautorizamos las peticiones cruzadas con .csrf().disable
        //Luego dentro de antMatchers definimos qué es lo que queremos permitir
        //El /**/ significa que sin importar lo que haya antes, cuando se llegué al endpoint de authenticate, podremos accederla
        http.csrf().disable().authorizeRequests()
                .antMatchers("/**/authenticate").permitAll()
                .anyRequest().authenticated() //Esta linea nos indica que para cualquier otra peticion diferente a /authenticate, se requerirán permisos,
                                              //por ejemplo la petición o endpoint /all
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean //Esta anotación la usaremos para indicarle a Spring explicitamente que será quien controlará la autenticación
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean(); //Dejamos el super como venia, así seguirá siendo Spring quien gestiones el proceso
    }
}
