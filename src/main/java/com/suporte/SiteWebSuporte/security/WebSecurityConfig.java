package com.suporte.SiteWebSuporte.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    // * Metodo de configuracao de acessos das paginas e de permissoes de acessos e
    // visualizacao */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // * Acessar o form login */
                // * Se o usuario e senha estiver correto, acessa a lsita de procedimentos,
                // pagina inicial */
                .antMatchers("/login").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/process-login")
                .defaultSuccessUrl("/")

                // *Retorna erro caso o usuario e senha estiver incorreto */
                .failureUrl("/login?error=true")
                .permitAll()
                .and()

                // * Faz o logout/encerra a SESSAO */
                .logout()
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                .csrf()
                .disable();
        ;

    }

    // * Metodo para comparar o usuario de login com o banco de dados*/
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from users where username=?");
    }

    // */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("visitante")
                // * SENHA GERADA ATRAVES DA CLASSE security/SecuredPasswordGenerator.java */
                .password("$2a$10$GzxHGdvF3cPAxj.QOymdReBnRhpGIQw0vHekWGShzEbKqpMTzyQzu")
                .roles("USER")
                .and()

                .withUser("admin")
                // * SENHA GERADA ATRAVES DA CLASSE security/SecuredPasswordGenerator.java */
                .password("$2a$10$ubJmSU3.CJWhzApkAB.sZOvFJ1VIa6bnxSiZxi3crKauWAWYm5YGC")
                .roles("ADMIN")
                .and();

    }

}