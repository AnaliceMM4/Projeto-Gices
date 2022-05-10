package projeto.Gices.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author analice
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)  
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ImplementsAdministratorDetailsService ads;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/administrator/**").permitAll()//, "/administrator/**"
                .antMatchers("/*/cadastrar").hasRole("ADMINISTRATOR")
                .antMatchers("/*/add").access("hasRole('ADMINISTRATOR')")
                .antMatchers("/*/editar/**").access("hasRole('ADMINISTRATOR')")
                .antMatchers("/*/update/**").access("hasRole('ADMINISTRATOR')")
                .antMatchers("/*/apagar/**").access("hasRole('ADMINISTRATOR')")
                //.antMatchers("/login-admin/**").permitAll()//.access("hasRole('USUARIO')")//)
                .antMatchers("/**").permitAll()
                .antMatchers("/index/**").permitAll()
                .antMatchers("/o-que-e/**").permitAll()
                .antMatchers("/legislacao/**").permitAll()
                .antMatchers("/deficientes-visuais/**").permitAll()
                .antMatchers("/processo-de-ensino-aprendizagem/**").permitAll()
                .antMatchers("/tecnologicos/**").permitAll()
                .antMatchers("/materiais-concretos/**").permitAll()
                .antMatchers("/lives/**").permitAll()
                .antMatchers("/grupo-de-pesquisa/**").permitAll()
                .antMatchers("/acessibilidade/**").permitAll()
                .antMatchers("/cadastro/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and().formLogin().loginPage("/login-admin")
                .defaultSuccessUrl("/index", true)
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/style.css/**")
                .antMatchers("/js/**")
                .antMatchers("/static/**")
                .antMatchers("/assets/**")
                .antMatchers("/vendors/**")
                .antMatchers("/webjars/**");
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return ads;//
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())//ou ads
                .passwordEncoder(passwordEncoder());
    }
    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(ads)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    //@Bean
    /*@Override
    protected UserDetailsService administratorDetailsService() {
        return administratorService;
    }*/
 /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(ads)
                .passwordEncoder(passwordEncoder());
    }

    @Configuration
    public class EncoderConfig {

        @Bean
        PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        /* @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
 /* }*/
}
