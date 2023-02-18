package es.iescabeza.aulasinformaticapsptr18.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig
{

    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception
    {

        http.authorizeHttpRequests()

                .requestMatchers("reservas/allReservations",
                        "reservas/selectAula", "reservas/selectTablets", "reservas/selectPcs",
                        "reservas/confirmReservation", "reservas/cancelReservation", "reservas/deleteReservaAula",
                        "reservas/deleteReservaCarroTablets", "reservas/deleteReservaCarroPcs").hasAnyRole("ADMIN", "USER")
                .requestMatchers("reservas/allReservations",
                        "reservas/selectAula", "reservas/selectTablets", "reservas/selectPcs",
                        "reservas/confirmReservation", "reservas/cancelReservation", "reservas/deleteReservaAula",
                        "reservas/deleteReservaCarroTablets", "reservas/deleteReservaCarroPcs").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and().httpBasic();

        return http.build();

    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        return new InMemoryUserDetailsManager(
                User.withUsername("jesus").password("{noop}demo").roles("ADMIN").build(),
                User.withUsername("aljarilla").password("{noop}demo").roles("USER").build()
        );
    }

}
