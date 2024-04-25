package com.example.config;
// package com.example.cinema.config;



// import com.example.cinema.entity.Role;
// import lombok.RequiredArgsConstructor;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.authentication.AuthenticationProvider;
// import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration
// @EnableGlobalMethodSecurity(prePostEnabled = true)
// @EnableWebSecurity
// @RequiredArgsConstructor
// public class SpringSecurity {

//     @Autowired
//     private AuthenticationProvider authenticationProvider;

//     @Autowired
//     private AuthFilterJwt jwtAuthFilter;

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http.csrf(csrf -> csrf.disable())
//                 .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                 .authorizeHttpRequests(auth ->
//                         auth.requestMatchers("/api/auth/**").permitAll()
//                                 .requestMatchers(HttpMethod.POST,"/api/auth/**").permitAll()
//                                 .requestMatchers("/api/admin").hasAnyRole(Role.ADMIN.name())
//                                 .requestMatchers("/api/user").hasAnyRole((Role.USER.name()))

//                                 .anyRequest().permitAll()
//                 )
//                 .formLogin().loginPage("/login").defaultSuccessUrl("/admin/home").permitAll()
//                 .and()
//                 .logout().permitAll();
//         http.authenticationProvider(authenticationProvider)
//                 .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//         return  http.build();
//     }


// }
