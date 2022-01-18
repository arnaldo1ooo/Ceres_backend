package com.ragnarok.ceres.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private AutenticacionService autenticacionService;
    
    
    // Configuraciones de autenticacion
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticacionService)
            .passwordEncoder(new BCryptPasswordEncoder());
        
        //System.out.println("Testee " + autenticacionService.convertirStringABCrypt("5127713"));
    }
    
    // Configuraciones de autorizacion de acceso, es en donde se ponen las url permitidas para el usuario logueado
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(HttpMethod.GET, "/departamentos").permitAll() // Pone como publicos todas las consultas a departamentos
            .antMatchers(HttpMethod.GET, "/departamentos/*").permitAll() // Pone como publicos todas las consultas individuales a departamentos
            .anyRequest().authenticated()	//Todo lo demas requiere autenticacion
            .and().formLogin();
    }
    
    // Configuraciones de recursos estaticos (js, css, png, etc)
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}