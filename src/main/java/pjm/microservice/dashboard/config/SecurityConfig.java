//package pjm.microservice.dashboard.config;
//
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
////    @Autowired
////    private JwtAuthenticationFilter jwtAuthenticationFilter;
//
////    @Autowired
////    private JwtUserDetailsService userService;
//
//    @Autowired
//    @Lazy
//    private PasswordEncoder passwordEncoder;
//
//
//    @Bean
//    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
////        http = http.cors().and().csrf().disable();
////
////        http = http
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and();
////
////        http = http
////                .exceptionHandling()
////                .authenticationEntryPoint(
////                        ((request, response, authException) ->{
////                            System.out.println("Unauthorized request");
////                            // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
////                            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
////                        })
////                )
////                .and();
//        return http.csrf(AbstractHttpConfigurer::disable)
//                .cors(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(request -> {
//                    request.requestMatchers("/").permitAll();
//                    request.requestMatchers("/users")
//                            .hasAnyAuthority("USER", "ADMIN");
//                }).formLogin(Customizer.withDefaults()).build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
