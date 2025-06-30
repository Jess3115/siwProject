package it.uniroma3.siw.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import it.uniroma3.siw.model.Role;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
// public class WebSecurityConfig {
public class AuthConfiguration {

        @Autowired
        private DataSource dataSource;

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth)
                        throws Exception {
                auth.jdbcAuthentication()
                                .dataSource(dataSource)
                                .authoritiesByUsernameQuery("SELECT username, role FROM credentials WHERE username=?")
                                .usersByUsernameQuery(
                                                "SELECT username, password, 1 as enabled FROM credentials WHERE username=?");
        }

        @Bean
        PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
                        throws Exception {
                return authenticationConfiguration.getAuthenticationManager();
        }

        @Bean
        SecurityFilterChain configure(final HttpSecurity httpSecurity) throws Exception {
                httpSecurity
                                .cors().disable()
                                .csrf().disable()
                                .authorizeHttpRequests(requests -> requests
                                                // Accesso pubblico - GET requests
                                                .requestMatchers(
                                                                HttpMethod.GET,
                                                                "/",
                                                                "/images/**",
                                                                "/index",
                                                                "/recipe",
                                                                "/recipe/**",
                                                                "/category/**",
                                                                "/ingredient-category",
                                                                "/ingredient/**",
                                                                "/login",
                                                                "/register")
                                                .permitAll()

                                                // Accesso pubblico - POST requests
                                                .requestMatchers(
                                                                HttpMethod.POST,
                                                                "/register")
                                                .permitAll()

                                                // Accesso pubblico alle risorse statiche
                                                .requestMatchers(
                                                                "/css/**",
                                                                "/js/**",
                                                                "/images/**",
                                                                "/static/**",
                                                                "/recipeImages/**",
                                                                "/favicon.ico",
                                                                "/webjars/**")
                                                .permitAll()

                                                // Accesso solo per utenti autenticati
                                                .requestMatchers("/personalArea/**", "/authenticated/**")
                                                .hasAnyAuthority(Role.DEFAULT.name(), Role.ADMIN.name())

                                                // Accesso solo per ADMIN
                                                .requestMatchers("/admin/**")
                                                .hasAnyAuthority(Role.ADMIN.name())

                                                // Tutte le altre richieste richiedono autenticazione
                                                .anyRequest().authenticated())
                                .formLogin(login -> login
                                                .loginPage("/login")
                                                .permitAll()
                                                .defaultSuccessUrl("/", true)
                                                .failureUrl("/login?error=true"))
                                .logout(logout -> logout
                                                .logoutUrl("/logout")
                                                .logoutSuccessUrl("/")
                                                .invalidateHttpSession(true)
                                                .deleteCookies("JSESSIONID")
                                                .permitAll());

                return httpSecurity.build();
        }
}
