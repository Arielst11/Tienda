/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author asanc
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
            .withUser("juan")
            .password("{noop}123")
            .roles("ADMIN","VENDEDOR","USER")
            .and()
            .withUser("rebeca")
            .password("{noop}123")
            .roles("VENDEDOR","USER")
            .and()
            .withUser("pedro")
            .password("{noop}123")
            .roles("USER");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests().
            antMatchers("/articulo/nuevo","/articulo/guardar", "/articulo/modificar/**", "/articulo/eliminar/**",  // SE PIDEN ESTOS
            "/categoria/nuevo","/categoria/guardar", "/categoria/modificar/**", "/categoria/eliminar/**",
            "/cliente/nuevo","/cliente/guardar", "/cliente/modificar/**", "/cliente/eliminar/**",
            "/usuario/nuevo","/usuario/guardar", "/usuario/modificar/**", "/usuario/eliminar/**"
            ).hasRole("ADMIN")                 // SE DA SI TIENE ESE ROLE
            .antMatchers("/articulo/listado",  // SE PIDEN 
                    "/categoria/listado",
                    "/cliente/listado")
            .hasAnyRole("ADMIN","VENDEDOR")   // SE DA SI TIENE ROLE
            .antMatchers("/")  // SE PIDE
            .hasAnyRole("ADMIN","VENDEDOR","USER") // SE DA SI TIENE ROLE
            .and()
            .formLogin()
            .loginPage("/login")
            .and()
            .exceptionHandling().accessDeniedPage("/errores/403");
    }
    
    
    
}
